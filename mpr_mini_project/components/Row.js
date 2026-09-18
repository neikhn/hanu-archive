  import { View, StyleSheet } from "react-native";

  export default function Row({ children }) {
    return (
      <View style={styles.container}>{children}</View>
    )
  };

  const styles = StyleSheet.create({
    container: {
      flexDirection: 'row', // Makes each row display containers horizontally
      alignItems: 'center', // Aligns content vertically within containers
      justifyContent: "space-between",
    }
  });