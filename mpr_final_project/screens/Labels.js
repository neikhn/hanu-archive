import React, { useState } from 'react';
import { StyleSheet, View, Modal, TextInput, Pressable, Text, AppRegistry } from 'react-native';
import Search from '../components/Search';
import LabelTag from '../components/LabelTag';
import { LABELS, NOTES, TRASH } from '../data/dummy-data';

const Label = ({ notes, setNote, trash, setTrash }) => {
    const [labels, setLabel] = useState(LABELS);
    [notes, setNote] = useState(NOTES);
    [trash, setTrash] = useState(TRASH);
    const [filteredLabels, setFilteredLabels] = useState(labels);
    const [pressedButton, setPressedButton] = useState(null);
    const [popUpModalVisible, setPopUpModalVisible] = useState(false);
    const [tempLabelText, setTempLabelText] = useState('');

    const handleLabelPress = (label) => {
        setPressedButton(label.id);
        setTempLabelText(label.label);
        setPopUpModalVisible(true);
    };

    const handleSaveLabel = () => {
        const updatedLabels = labels.map(label =>
            label.id === pressedButton ? { ...label, label: tempLabelText } : label
        );
        setLabel(updatedLabels);
        setFilteredLabels(updatedLabels);
    
        const updatedNotes = notes.map(note => ({
            ...note,
            labelIds: note.labelIds.map(labelId => labelId === pressedButton ? tempLabelText : labelId)
        }));
        setNote(updatedNotes);
    
        const updatedTrash = trash.map(item => ({
            ...item,
            labelIds: item.labelIds.map(labelId => labelId === pressedButton ? tempLabelText : labelId)
        }));
        setTrash(updatedTrash);
    
        setPopUpModalVisible(false);
        setPressedButton(null);
    
        // Directly mutate LABELS
        LABELS.forEach((label, index) => {
            if (label.id === pressedButton) {
                LABELS[index].label = tempLabelText;
            }
        });
    };

    const handleDeleteLabel = () => {
        const updatedLabels = labels.filter(label => label.id !== pressedButton);
        setLabel(updatedLabels);
        setFilteredLabels(updatedLabels);
    
        const updatedNotes = notes.map(note => ({
            ...note,
            labelIds: note.labelIds.filter(labelId => labelId !== pressedButton)
        }));
        setNote(updatedNotes);
    
        const updatedTrash = trash.map(item => ({
            ...item,
            labelIds: item.labelIds.filter(labelId => labelId !== pressedButton)
        }));
        setTrash(updatedTrash);
    
        setPopUpModalVisible(false);
        setPressedButton(null);
    
        // Directly mutate LABELS
        LABELS.splice(
            LABELS.findIndex(label => label.id === pressedButton),
            1
        );
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
        // Update the dummy data
        LABELS.push(newLabel);
    };

    const handleSearch = (filteredLabels) => {
        setFilteredLabels(filteredLabels);
    };

    if (!notes || !trash) {
        return <Text>Loading...</Text>;
    }

    return (
        <View style={styles.container}>
            <Search labels={labels} onSearch={handleSearch} onCreateLabel={handleCreateLabel} />

            <View style={styles.labelList}>
                {filteredLabels.map(label => (
                    <LabelTag
                        key={label.id}
                        label={label}
                        isPressable={true}
                        onPress={() => handleLabelPress(label)}
                    />
                ))}
            </View>

            <Modal
                visible={popUpModalVisible}
                animationType="fade"
                transparent={true}
            >
                <Pressable style={styles.popUpModalOverlay} onPress={() => setPopUpModalVisible(false)}>
                    <View style={styles.popUpModalContainer} onStartShouldSetResponder={() => true}>
                        <TextInput
                            style={styles.popUpModalText}
                            value={tempLabelText}
                            onChangeText={(text) => setTempLabelText(text)}
                        />
                        <View style={styles.popUpButtonContainer}>
                            <Pressable onPress={handleSaveLabel}>
                                <Text style={styles.popUpButtonText}>Save</Text>
                            </Pressable>
                            <Pressable onPress={handleDeleteLabel}>
                                <Text style={styles.popUpButtonText}>Delete</Text>
                            </Pressable>
                        </View>
                    </View>
                </Pressable>
            </Modal>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        flexDirection: 'column',
        paddingTop: 40,
    },
    labelList: {
        flexDirection: 'row',
        flexWrap: 'wrap',
        padding: 5,
    },
    popUpModalOverlay: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'rgba(0, 0, 0, 0.6)',
    },
    popUpModalContainer: {
        backgroundColor: 'white',
        padding: 20,
        margin: 50,
        borderRadius: 10,
        justifyContent: 'flex-start',
        width: 300,
    },
    popUpButtonContainer: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
    },
    popUpModalText: {
        fontSize: 20,
        fontWeight: 'bold',
        padding: 5,
        marginBottom: 30,
        borderBottomWidth: 1,
    },
    popUpButtonText: {
        fontSize: 20,
        fontWeight: 'bold',
    },
});

AppRegistry.registerComponent('main', () => Label);

export default Label;
