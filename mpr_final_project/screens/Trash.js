import React, { useState, useEffect } from "react";
import { View, StyleSheet, FlatList, Modal, Pressable, Text } from "react-native";
import { TRASH, NOTES } from "../data/dummy-data";
import NoteContainer from "../components/NoteContainer";

export default function Home({ navigation }) {
    const [trash, setTrash] = useState(TRASH);
    const [modalVisible, setModalVisible] = useState(false);
    const [selectedNote, setSelectedNote] = useState(null);

    useEffect(() => {
        const unsubscribe = navigation.addListener('focus', () => {
            // Update trash state to trigger re-render
            setTrash(TRASH.slice()); // Copying array to trigger state update
        });

        return unsubscribe;
    }, [navigation]);

    function handleRestore() {
        if (selectedNote) {
            const index = TRASH.findIndex((item) => item.id === selectedNote.id);
            if (index !== -1) {
                NOTES.unshift(TRASH[index]); // Add to NOTES
                TRASH.splice(index, 1); // Remove from TRASH
                setTrash(TRASH.slice()); // Update state
            }
            setModalVisible(false);
        }
    }

    function handleDelete() {
        if (selectedNote) {
            const index = TRASH.findIndex((item) => item.id === selectedNote.id);
            if (index !== -1) {
                TRASH.splice(index, 1); // Remove from TRASH
                setTrash(TRASH.slice()); // Update state
            }
            setModalVisible(false);
        }
    }

    function handleRestoreAll() {
        NOTES.unshift(...TRASH); // Move all from TRASH to NOTES
        TRASH.length = 0; // Clear TRASH
        setTrash(TRASH.slice()); // Update state
    }

    function handleDeleteAll() {
        TRASH.length = 0; // Clear TRASH
        setTrash(TRASH.slice()); // Update state
    }

    function renderTrashItem({ item }) {
        function trashContainerPressHandler() {
            setSelectedNote(item);
            setModalVisible(true);
        }

        return (
            <NoteContainer note={item} onPress={trashContainerPressHandler} />
        );
    }

    return (
        <View style={styles.container}>
            <View style={styles.firstLineContainer}>
                <Text style={styles.trashNumber}> {trash.length} notes in trash </Text>
                <View style={styles.restoreEmptyContainer}>
                    <Pressable style={styles.restoreButton} onPress={handleRestoreAll}>
                        <Text style={styles.restoreText}>Restore All</Text>
                    </Pressable>
                    <Pressable style={styles.emptyButton} onPress={handleDeleteAll}>
                        <Text style={styles.emptyText}>Empty All</Text>
                    </Pressable>
                </View>
            </View>

            <FlatList
                data={trash}
                keyExtractor={(item) => item.id}
                renderItem={renderTrashItem}
                extraData={trash} // Ensure re-render on state change
            />

            <Modal visible={modalVisible} animationType="fade" transparent={true}>
                <Pressable style={styles.modalOverlay} onPress={() => setModalVisible(false)}>
                    <View style={styles.modalContainer} onStartShouldSetResponder={() => true}>
                        <Pressable style={styles.modalPressable} onPress={handleRestore}>
                            <Text style={styles.modalTextRestore}>Restore</Text>
                        </Pressable>
                        <Pressable style={styles.modalPressable} onPress={handleDelete}>
                            <Text style={styles.modalTextDelete}>Delete</Text>
                        </Pressable>
                    </View>
                </Pressable>
            </Modal>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignContent: "center",
    },
    firstLineContainer: {
        flexDirection: "row",
        justifyContent: "space-between",
        alignItems: "center",
        padding: 10,
    },
    trashNumber: {
        fontSize: 16,
        color: "#0c1ee8",
    },
    restoreEmptyContainer: {
        flexDirection: "row",
    },
    restoreButton: {
        padding: 10,
        borderRadius: 10,
        backgroundColor: "#d9d9d9",
        marginRight: 10,
    },
    restoreText: {
        fontSize: 16,
        color: "black",
    },
    emptyButton: {
        padding: 10,
        borderRadius: 10,
        backgroundColor: "red",
    },
    emptyText: {
        fontSize: 16,
        color: "#fff",
    },
    modalOverlay: {
        flex: 1,
        backgroundColor: 'rgba(0, 0, 0, 0.5)',
        justifyContent: 'center',
        alignItems: 'center',
    },
    modalContainer: {
        backgroundColor: 'white',
        padding: 20,
        width: 200,
        borderRadius: 10,
    },
    modalPressable: {
        padding: 10,
        alignItems: 'center',
    },
    modalTextRestore: {
        fontSize: 16,
        color: '#0c1ee8',
    },
    modalTextDelete: {
        fontSize: 16,
        color: 'red',
    },
});
