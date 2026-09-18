import PropTypes from "prop-types";
import { View, Text, Pressable, StyleSheet } from "react-native";

export default function InputButton({ children, onPress, type, disabled }) {
  const isNumber = (type === "number");

  return (
    <View style={styles.outerContainer}>
      <Pressable
        style={({ pressed }) => [
          isNumber ? styles.primaryContainer : styles.secondaryContainer,
          pressed ? (isNumber ? styles.primaryFeedbackFlash : styles.secondaryFeedbackFlash) : null,
          pressed && !disabled ? styles.feedbackFlash : null, //feedbackFlash only when button is not disabled
          disabled ? styles.disabledContainer : null
        ]}
        onPress={onPress}
        disabled={disabled}
      >
        <Text style={styles.buttonText}>{children}</Text>
      </Pressable>
    </View>
  );
}

InputButton.propTypes = {
  children: PropTypes.string.isRequired,
  onPress: PropTypes.func.isRequired, 
  type: PropTypes.oneOf(['number', 'operator']).isRequired, 
};

const styles = StyleSheet.create({
  outerContainer: {
    margin: 10
  },
  primaryContainer: {
    width: 70,
    aspectRatio: 1,
    justifyContent: "center",
    backgroundColor: "#FC5E5E",
    borderRadius: 20
  },
  secondaryContainer: {
    width: 70,
    aspectRatio: 1,
    justifyContent: "center",
    backgroundColor: "#5E6EFC",
    borderRadius: 20
  },
  disabledContainer: {
    backgroundColor: "#C4C4C4"
  },
  buttonText: {
    fontSize: 20,
    fontWeight: "800",
    color: "white",
    textAlign: "center"
  },
  primaryFeedbackFlash: {
    backgroundColor: "#C73659"
  },
  secondaryFeedbackFlash: {
    backgroundColor: "#3E4ABB"
  }
});