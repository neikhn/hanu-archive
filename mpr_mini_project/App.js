import { useState, useEffect } from "react";
import { StyleSheet, View, Text } from "react-native";
import InputButton from "./components/Button/InputButton.js";
import Row from "./components/Row.js";
import DisplayContainer from "./components/DisplayContainer.js";
import HelperButton from "./components/Button/HelperButton.js";
import FeedbackContainer from "./components/FeedbackContainer.js";
import NotifyModal from "./components/NotifyModal.js";

export default function App() {
  const [yourValue, setYourValue] = useState("");
  const [targetValue, setTargetValue] = useState(9);
  const [trial, setTrial] = useState(3);
  const [displayValue, setDisplayValue] = useState("");
  const [availableNumber, setAvailableNumber] = useState([]);
  const [solution, setSolution] = useState("");

  //Handle disabling option(s)
  const [previousInput, setPreviousInput] = useState("");
  const [usedNumber, setUsedNumber] = useState([]);

  //Handle notification
  const [notifyVisible, setNotifyVisible] = useState(false);
  const [notifyMessage, setNotifyMessage] = useState("");
  const [notifyButtonStatus, setNotifyButtonStatus] = useState("");

  const generateAvailableNumber = () => {
    const array = [];
    const generatedNumbers = new Set();
    while (array.length < 4) {
      const randomInteger = Math.floor(Math.random() * 99) + 1;
      // Check if the random integer has not been generated before
      if (!generatedNumbers.has(randomInteger)) {
        generatedNumbers.add(randomInteger);
        array.push(randomInteger);
      }
    }
    setAvailableNumber(array);
  };

  const generateRandomOperator = () => {
    const operators = ["+", "-", "*", "/"];
    return operators[Math.floor(Math.random() * operators.length)];
  };

  const generateTargetValue = () => {
    if (availableNumber.length < 4) return;
    let result;
    let expression;
    do {
      expression = `${availableNumber[0]} ${generateRandomOperator()} ${availableNumber[1]} ${generateRandomOperator()} ${availableNumber[2]} ${generateRandomOperator()} ${availableNumber[3]}`;
      try {
        result = eval(expression);
      } catch (error) {
        console.error(
          "Failed to generate target value from expression:",
          expression
        );
        result = null;
      }
    } while ( 
      // target value conditions
      result === null ||
      result < 1 ||
      result > 999 ||
      !Number.isInteger(result)
    );

    if (!Number.isInteger(result)) {
      generateAvailableNumber(); // Regenerate available numbers and target value
    } else {
      console.log("Generated expression: " + expression);
      console.log("Target value: " + result);
      setTargetValue(result);
      setSolution(expression);
    }
  };

  useEffect(() => {
    generateTargetValue();
  }, [availableNumber]);

  // initial run everytime app start
  useEffect(() => {
    generateAvailableNumber();
  }, []);

  const handlePress = (value) => {
    setDisplayValue((previous) => {
      const isPreviousEmpty = previousInput === "";
      const isDifferentType = isNaN(previousInput) !== isNaN(value);
      const isCurrentNumber = !isNaN(value);

      allowed =
        (isPreviousEmpty && isCurrentNumber) ||
        (isDifferentType && !isPreviousEmpty);

      if (allowed) {
        setPreviousInput(value);
        setUsedNumber([...usedNumber, value]);
        return previous === "" ? String(value) : previous + value;
      }
      return previous;
    });
  };

  const handleReset = () => {
    setDisplayValue("");
    setPreviousInput("");
    setUsedNumber([]);
  };

  const handleNewGame = () => {
    setTrial(3);
    setDisplayValue("");
    setPreviousInput("");
    setUsedNumber([]);
    setYourValue("");
    generateAvailableNumber();
  };

  const handleCheck = (expression) => {
    try {
      const result = eval(expression);
      setYourValue(result);
    } catch (error) {
      setNotifyMessage("INVALID EXPRESSION");
      setNotifyButtonStatus("RE-TRY");
      setNotifyVisible(true);
    }
  };

  useEffect(() => {
    if (trial === 0) {
      setNotifyMessage(
        "Unfortunately\nYou have run out of trials. Tap the button to start a new game."
      );
      setNotifyButtonStatus("New Game");
      setNotifyVisible(true);
    }
  }, [trial]);

  useEffect(() => {
    if (yourValue !== "") {
      if (targetValue === yourValue) {
        setNotifyMessage(
          "Congratulations!\nYou won the game. Tap the button to start a new game."
        );
        setNotifyButtonStatus("New Game");
        setNotifyVisible(true);
      } else {
        setTrial((previousTrial) => previousTrial - 1);
        setNotifyMessage(
          "Your expression is incorrect!\nTap the button to try again."
        );
        setNotifyButtonStatus("Reset");
        setNotifyVisible(true);
      }
    }
  }, [yourValue]);

  const closeModal = () => {
    setNotifyVisible(false);
    if (notifyButtonStatus === "Reset") {
      handleReset();
    } else if (notifyButtonStatus === "New Game") {
      handleNewGame();
    }
  };

  return (
    <View style={styles.container}>
      <Row>
        <FeedbackContainer value={yourValue}>YOUR VALUE</FeedbackContainer>
        <FeedbackContainer value={targetValue}>TARGET VALUE</FeedbackContainer>
        <FeedbackContainer value={trial}>TRIALS</FeedbackContainer>
      </Row>
      <Row>
        <DisplayContainer>{displayValue}</DisplayContainer>
      </Row>
      <Row>
        {availableNumber.slice(0, 2).map((item) => (
          <InputButton
            key={item}
            onPress={() => handlePress(item)}
            type="number"
            disabled={usedNumber.includes(item)}
          >
            {String(item)}
          </InputButton>
        ))}
        {["+", "-"].map((item) => (
          <InputButton
            key={item}
            onPress={() => handlePress(item)}
            type="operator"
          >
            {item}
          </InputButton>
        ))}
      </Row>
      <Row>
        {availableNumber.slice(2, 4).map((item) => (
          <InputButton
            key={item}
            onPress={() => handlePress(item)}
            type="number"
            disabled={usedNumber.includes(item)}
          >
            {String(item)}
          </InputButton>
        ))}
        {["*", "/"].map((item) => (
          <InputButton
            key={item}
            onPress={() => handlePress(item)}
            type="operator"
          >
            {item}
          </InputButton>
        ))}
      </Row>
      <Row>
        <HelperButton onPress={handleReset}>Reset</HelperButton>
        <HelperButton onPress={() => handleCheck(displayValue)}>
          Check
        </HelperButton>
      </Row>
      <NotifyModal
        visible={notifyVisible}
        buttonContent={notifyButtonStatus}
        onClose={closeModal}
      >
        {notifyMessage}
      </NotifyModal>
      <View>
        <Text>{solution}</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    padding: 10,
    backgroundColor: "#EEEEEE",
  },
});
