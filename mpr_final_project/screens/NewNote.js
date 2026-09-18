import { StyleSheet, View } from "react-native";
import { useState } from "react";
import TextScrollView from "../components/TextScrollView";
import ActionButton from "../components/ActionButton";
import { NOTES, TRASH } from "../data/dummy-data";
import Note from "../models/note";

export default function NewNote({ navigation }) {
  const [content, setContent] = useState("");

  const handleConfirmPress = () => {
    const newId = generateUniqueId();
    const newNote = new Note(
      newId,
      null,
      [],
      content,
      new Date(),
      false
    );
    // Insert new note at beginning of NOTES 
    NOTES.unshift(newNote);
    navigation.navigate('Home');
  };

  const generateUniqueId = () => {
    const existingIds = new Set(
      [...NOTES, ...TRASH].map(note => note.id).filter(Boolean)
    );
    let id;
    let num = 1;
    do {
      id = `n${num}`;
      num++;
    } while (existingIds.has(id));
    return id;
  };

  return (
    <View style={styles.container}>
      <TextScrollView content={content} onContentChange={setContent} />
      <ActionButton type='check' onPress={handleConfirmPress}></ActionButton>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignContent: "center",
  },
});
