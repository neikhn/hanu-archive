import { StyleSheet, Pressable, View, Text, Modal } from "react-native";
import { useEffect, useState } from "react";
import { formatDistanceToNow } from "date-fns";
import LabelContainer from "../components/LabelContainer";
import { NOTES, TRASH } from "../data/dummy-data";

import Icon from "react-native-vector-icons/Ionicons";
import BottomPressable from "../components/bottomModelPressable.js";
import BottomModalColor from "../components/bottomModalColor.js";
import TextScrollView from "../components/TextScrollView.js";

export default function EditNote({ route, navigation }) {
  const { id } = route.params;
  const [drawerVisible, setDrawerVisible] = useState(false);
  const [pressedButton, setPressedButton] = useState(null);
  const [bottomModalVisible, setBottomModalVisible] = useState(false);
  const [noteContent, setNoteContent] = useState(null);

  useEffect(() => {
    const fetchedNote = NOTES.find((note) => note.id === id);
    setNoteContent(fetchedNote);
  }, [id]);

  if (!noteContent) {
    return null; // or render a loading indicator
  }

  // Toggle bookmark status
  const handleBookMarkPress = () => {
    setNoteContent((prevNote) => {
      const updatedNote = {
        ...prevNote,
        isBookmarked: !prevNote.isBookmarked,
      };
      updateNoteInDummyData(updatedNote); // Update the note in the NOTES array
      return updatedNote;
    });
  };

  const handleContentChange = (newContent) => {
    setNoteContent((prevNote) => {
      const updatedNote = {
        ...prevNote,
        content: newContent,
      };
      updateNoteInDummyData(updatedNote);
      return updatedNote;
    });
  };

  const updateNoteInDummyData = (updatedNote) => {
    const noteIndex = NOTES.findIndex((note) => note.id === updatedNote.id);
    if (noteIndex !== -1) {
      NOTES[noteIndex] = updatedNote;
    }
  };

  const handleColorSelection = (color) => {
    setNoteContent((prevNote) => {
        const updatedNote = {
            ...prevNote,
            color: color, // Assuming your noteContent has a 'color' property
        };
        updateNoteInDummyData(updatedNote);
        return updatedNote;
    });
};

  const handleToManageLabel = (item) => {
    navigation.navigate('Manage labels', {
      id: item.id,
      updateLabels: (updatedLabels) => {
        setNoteContent((prevNote) => {
          const updatedNote = { ...prevNote, labels: updatedLabels };
          updateNoteInDummyData(updatedNote);
          return updatedNote;
        });
      },
    });
  }

  const handleCopyToClipboard = () => {
    console.log("Copy to clipboard pressed");
  };

  const handleShare = () => {
    console.log("Share pressed");
  };

  const handleTrash = () => {
    const noteIndex = NOTES.findIndex((note) => note.id === noteContent.id);
    if (noteIndex !== -1) {
      const noteToTrash = NOTES.splice(noteIndex, 1)[0]; // Remove from NOTES
      TRASH.push(noteToTrash); // Add to TRASH
      navigation.goBack(); // Navigate back after moving to trash
    }
  };
  const handleMakeACopy = () => {
    console.log("Make a copy pressed");
  };

  const handlePin = () => {
    console.log("Pin pressed");
  };

  const handleAddReminder = () => {
    console.log("Add a reminder pressed");
  };

  return (
    <View style={styles.container}>
      <View style={styles.labelContainer}>
        <LabelContainer note={noteContent} />
      </View>
      <TextScrollView content={noteContent.content} onContentChange={handleContentChange} />
      <View style={styles.bottomTabMenu}>
        <Text style={styles.noteTime}>
          {formatDistanceToNow(new Date(noteContent.updateAt), {
            addSuffix: true,
          })}
        </Text>

        <Pressable onPress={handleBookMarkPress}>
          <Icon
            style={styles.bottomIcon}
            name={noteContent.isBookmarked ? "bookmark" : "bookmark-outline"}
          />
        </Pressable>

        <Pressable onPress={() => setBottomModalVisible(true)}>
          <Icon style={styles.bottomIcon} name="ellipsis-vertical-outline" />
        </Pressable>
      </View>

      <Modal visible={bottomModalVisible} animationType="slide" transparent={true}>
        <Pressable style={styles.bottomModalOverlay} onPress={() => setBottomModalVisible(false)}>
          <View style={styles.bottomModalContainer} onStartShouldSetResponder={() => true}>
            <View style={styles.bottomColorContainer}>
              <BottomModalColor
                onPress={handleColorSelection }
                selectedColor={noteContent.color}
              />
            </View>
            <View style={styles.bottomModalLabel}>
              <LabelContainer note={noteContent}></LabelContainer>
              <Pressable style={styles.toManageLabel} onPress={() => handleToManageLabel(noteContent)} >
                <Text style={styles.toManageLabelText}>+ Manage labels</Text>
              </Pressable>
            </View>
            <BottomPressable iconName="clipboard-outline" text="Copy to clipboard" onPress={handleCopyToClipboard} />
            <BottomPressable iconName="share-social-outline" text="Share" onPress={handleShare} />
            <BottomPressable iconName="trash-outline" text="Trash" onPress={handleTrash} />
            <BottomPressable iconName="copy-outline" text="Make a copy" onPress={handleMakeACopy} />
            <BottomPressable iconName="pin-outline" text="Pin" onPress={handlePin} />
            <BottomPressable iconName="alarm-outline" text="Add a reminder" onPress={handleAddReminder} />
          </View>
        </Pressable>
      </Modal>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "column",
  },
  labelContainer: {
    margin: 10,
  },
  bottomTabMenu: {
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
    paddingHorizontal: 10,
    paddingVertical: 10,
    marginHorizontal: 4,
    backgroundColor: "#d9d9d9",
    width: "100%",
    position: "absolute",
    bottom: 0,
    left: 0,
    right: 0,
    zIndex: 1,
    borderWidth: 1,
    borderColor: "#000",
  },
  bottomText: {
    fontSize: 12,
    fontWeight: "bold",
  },
  bottomIcon: {
    fontSize: 20,
    fontWeight: "bold",
  },
  bottomModalOverlay: {
    flex: 1,
    justifyContent: "flex-end",
    backgroundColor: "rgba(0, 0, 0, 0.7)",
  },
  bottomModalContainer: {
    backgroundColor: "#fff",
    padding: 20,
    borderTopLeftRadius: 20,
    borderTopRightRadius: 20,
  },
  bottomModalLabel: {
    flexWrap: "wrap",
    flexDirection: "row",
    justifyContent: "flex-start",
    marginBottom: 20,
  },

  toManageLabel: {
    padding: 5,
    borderRadius: 5,
    flexWrap: "wrap",
    margin: 5,
    alignSelf: "flex-start",
    backgroundColor: "#d9d9d9",
  },
  toManageLabelText: {
    color: "black",
    fontSize: 12,
  },
  bottomColorContainer: {
    flexDirection: "row",
    justifyContent: "flex-start",
    alignItems: "center",
    marginBottom: 20,
  },
  noColor: {
    fontSize: 20,
    color: "#000",
  },
});
