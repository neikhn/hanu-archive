import { StyleSheet, View, Text } from "react-native";
import DisplayContainer from "./DisplayContainer.js";

export default function FeedbackContainer({ children, value }) {
  return (
    <View style={styles.container}>
      <Text style={styles.feedbackText}>{children}</Text>
      <View style={styles.displayContainer}>
        <Text style={styles.displayText}>{value}</Text>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    width: "33%",
  },
  feedbackText: {
    color: "#C73659",
    fontWeight: "800",
    fontSize: 16,
    textAlign: "center",
  },
  displayContainer: {
    margin: 10,
    height: 70,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#D1D8C5",
    borderRadius: 20,
    padding: 20,
    marginBottom: 20,
  },
  displayText: {
    fontSize: 25,
  }
});