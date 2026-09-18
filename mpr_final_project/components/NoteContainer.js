import React, { useState } from "react";
import { View, Text, StyleSheet, Pressable } from "react-native";
import { formatDistanceToNow } from "date-fns";
import Icon from "react-native-vector-icons/Ionicons";
import LabelContainer from "./LabelContainer";

export default function NoteContainer({ note, onPress }) {
  const [expanded, setExpanded] = useState(false);

  const toggleExpansion = () => {
    setExpanded(!expanded);
  };

  const renderContent = () => {
    const maxLines = expanded ? 1000 : 10;
    return (
      <Text numberOfLines={maxLines} style={styles.noteContent}>
        {note.content}
      </Text>
    );
  };

  const isBookmarked = note.isBookmarked;

  return (
    <View style={styles.container}>
      <Pressable
        style={({ pressed }) => [pressed ? styles.notePressed : null]}
        onPress={onPress}
      >
        <View style={styles.colorTimeBookmarkContainer}>
          <View style={styles.colorTimeContainer}>
            {note.color && (
              <View
                style={[styles.noteColor, { backgroundColor: note.color }]}
              />
            )}
            <Text style={styles.noteTime}>
              {formatDistanceToNow(new Date(note.updateAt), {
                addSuffix: true,
              })}
            </Text>
          </View>
          <Icon
            style={isBookmarked ? styles.bookMarked : styles.notBookMarked}
            name="bookmark"
          ></Icon>
        </View>
        <LabelContainer note={note} />
        {renderContent()}
        {note.content.split("\n").length > 10 && (
          <Pressable onPress={toggleExpansion}>
            <Text style={styles.toggleButton}>
              {expanded ? "Minimize" : "Expand"}
            </Text>
          </Pressable>
        )}
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: "white",
    borderRadius: 10,
    padding: 20,
    margin: 10,
    // Shadow for iOS
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.3,
    shadowRadius: 3.84,
    // Elevation for Android
    elevation: 5,
  },
  colorTimeBookmarkContainer: {
    flexDirection: "row",
    justifyContent: "space-between",
  },
  bookMarked: {
    fontSize: 16,
    color: "grey",
  },
  notBookMarked: {
    display: "none",
  },
  colorTimeContainer: {
    flexDirection: "row",
    alignItems: "center",
    marginBottom: 10,
  },
  noteColor: {
    width: 12,
    aspectRatio: 1,
    borderRadius: 25,
    marginRight: 5,
  },
  noteContent: {
    color: "black",
    fontSize: 16,
  },
  noteTime: {
    fontSize: 12,
    color: "gray",
  },
  notePressed: {
    opacity: 0.5,
  },
  toggleButton: {
    color: "blue",
    textDecorationLine: "underline",
    marginTop: 5,
  },
});
