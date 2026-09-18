import { useEffect, useState } from "react";
import { ScrollView, TextInput, StyleSheet } from "react-native";

export default function TextScrollView({ content, onContentChange }) {
  const [text, setText] = useState(content);

  useEffect(() => {
    setText(content);
  }, [content]);

  const handleChangeText = (newText) => {
    setText(newText);
    onContentChange(newText);
  };

  return (
    <ScrollView style={styles.noteContentContainer}>
      <TextInput
        style={[styles.inputContainer, styles.inputText]}
        onChangeText={handleChangeText}
        value={text}
        multiline
        numberOfLines={500}
        placeholder="Enter text.."
      />
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  noteContentContainer: {
    marginHorizontal: 10,
  },
  inputContainer: {
    padding: 8,
    marginTop: 20,
    width: "100%",
    height: 400,
    backgroundColor: "#d9d9d9",
    borderRadius: 10,
    textAlignVertical: "top",
  },
  inputText: {
    fontSize: 16,
  },
});
