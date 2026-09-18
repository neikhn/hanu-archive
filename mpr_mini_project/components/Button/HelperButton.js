import { View, Text, Pressable, StyleSheet } from "react-native";

export default function HelperButton({ children, onPress }) {
  return (
    <View style={styles.outerContainer}>
    <Pressable
        style={({ pressed }) => [
          styles.innerContainer,
          pressed ? styles.feedbackFlash : null
      ]}
      onPress={onPress}
    >
      <Text style={styles.buttonText}>{children}</Text>
    </Pressable>
  </View>
  )
}

const styles = StyleSheet.create({
  outerContainer: {
    margin: 10
  },
  innerContainer: {
    width: 150,
    height: 70,
    justifyContent: "center",
    backgroundColor: "#FC5E5E",
    borderRadius: 20
  },
  feedbackFlash: {
    backgroundColor: "#C73659"
  },
  buttonText: {
    fontSize: 20,
    fontWeight: "800",
    color: "white",
    textAlign: "center"
  },
});