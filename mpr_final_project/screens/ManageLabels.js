import { StyleSheet, View, AppRegistry } from "react-native";
import React, { useState, useEffect } from "react";
import Search from "../components/Search";
import LabelTag from "../components/LabelTag";
import { LABELS, NOTES } from "../data/dummy-data";

const ManageLabel = ({ route, navigation }) => {
    const { id, updateLabels } = route.params;
    const [labels, setLabel] = useState(LABELS);
    const [notes, setNotes] = useState(NOTES);
    const [filteredLabels, setFilteredLabels] = useState(labels);
    const [selectedLabels, setSelectedLabels] = useState([]);

    useEffect(() => {
        const note = notes.find((note) => note.id === id);
        if (note) {
            setSelectedLabels(note.labelIds || []);
        }
    }, [id, notes]);

    const handleToggleLabel = (labelId) => {
        setSelectedLabels((prevSelectedLabels) => {
            const isSelected = prevSelectedLabels.includes(labelId);
            const updatedSelectedLabels = isSelected
                ? prevSelectedLabels.filter((id) => id !== labelId)
                : [...prevSelectedLabels, labelId];

            // Update labels in the parent component
            updateLabels(updatedSelectedLabels);

            // Update labels in the dummy data
            const updatedNotes = notes.map((note) => {
                if (note.id === id) {
                    return { ...note, labelIds: updatedSelectedLabels };
                }
                return note;
            });

            // Directly modify the dummy data
            const noteIndex = NOTES.findIndex((note) => note.id === id);
            if (noteIndex !== -1) {
                NOTES[noteIndex].labelIds = updatedSelectedLabels;
            }

            setNotes(updatedNotes);
            return updatedSelectedLabels;
        });
    };

    const isLabelSelected = (labelId) => {
        return selectedLabels.includes(labelId);
    };

    const handleCreateLabel = (label) => {
        if (!label.trim()) {
            return;
        }

        const maxId = labels.reduce((max, existingLabel) => {
            if (existingLabel.id && typeof existingLabel.id === 'string') {
                const labelIdNumber = parseInt(existingLabel.id.substring(1));
                return labelIdNumber > max ? labelIdNumber : max;
            }
            return max;
        }, 0);

        const newId = `l${maxId + 1}`;
        const newLabel = { id: newId, label: label };
        const updatedLabels = [...labels, newLabel];

        setLabel(updatedLabels);
        setFilteredLabels(updatedLabels);   
        LABELS.push(newLabel);
    };

    const handleSearch = (filteredLabels) => {
        setFilteredLabels(filteredLabels);
    };


    return (
        <View style={styles.container}>
            <Search labels={labels} onSearch={handleSearch} onCreateLabel={handleCreateLabel} />
            <View style={styles.labelList}>
                {filteredLabels.map(label => (
                    <View key={label.id} style={{ opacity: isLabelSelected(label.id) ? 0.7 : 1 }}>
                        <LabelTag
                            label={label}
                            isPressable={true}
                            onPress={() => handleToggleLabel(label.id)}
                        />
                    </View>
                ))}
            </View>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        flexDirection: "column",
    },
    navBar: {
        flexDirection: "row",
        justifyContent: "space-between",
        alignItems: "center",
        paddingHorizontal: 10,
        paddingVertical: 20,
        backgroundColor: "#fff",
        width: "100%",
        position: "absolute",
        top: 0,
        left: 0,
        right: 0,
        zIndex: 1,
        marginLeft: 0,
        marginTop: 30,
    },
    navButton: {
        paddingVertical: 10,
        paddingHorizontal: 20,
        backgroundColor: "#fff",
    },
    navButtonPressed: {
        backgroundColor: "#9bb9e8",
    },
    navButtonText: {
        fontSize: 18,
        fontWeight: "bold",
    },
    labelList: {
        flexDirection: "row",
        flexWrap: "wrap",
        justifyContent: "flex-start",
        padding: 5,
    },
});

AppRegistry.registerComponent('main', () => ManageLabel);

export default ManageLabel;
