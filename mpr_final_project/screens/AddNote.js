import { StyleSheet, Pressable, View, Text, Modal, TextInput, AppRegistry, ScrollView } from "react-native";
import React, { useState } from "react";
import Icon from 'react-native-vector-icons/Ionicons';
import TextScrollView from "../components/TextScrollView";

const AddNote = () => {
    const [drawerVisible, setDrawerVisible] = useState(false);
    const [pressedButton, setPressedButton] = useState(null);
    const [searchVisible, setSearchVisible] = useState(false);
    const [text, setText] = useState('');

    const handlePressIn = (button) => {
        setPressedButton(button);
    };

    const handlePressOut = () => {
        setPressedButton(null);
    };

    const isButtonPressed = (button) => pressedButton === button;

    return (
        <View style={styles.container}>
            <View style={styles.navBar}>
                <Pressable
                    style={[styles.navButton, isButtonPressed('Menu') && styles.navButtonPressed]}
                    onPress={() => setDrawerVisible(true)}
                >
                    <Text style={styles.navButtonText}>Menu</Text>
                </Pressable>
            </View>


            <TextScrollView/>

            <View style={styles.addNoteButton}>
                <Icon style={styles.addNoteIcon} name="checkmark-outline"></Icon>
            </View>

            <Modal
                visible={drawerVisible}
                animationType="fade"
                transparent={true}
            >
                <Pressable style={styles.modalOverlay} onPress={() => setDrawerVisible(false)}>
                    <View style={styles.modalContainer} onStartShouldSetResponder={() => true}>
                        <Text style={styles.modalText}>Notes App</Text>
                        <Pressable
                            style={[
                                styles.linkButtonContainer,
                                isButtonPressed('Home') && styles.linkButtonContainerPressed
                            ]}
                            onPressIn={() => handlePressIn('Home')}
                            onPressOut={handlePressOut}
                        //onPress={() => navigation.navigate('Home')}
                        >
                            <Text style={[
                                styles.linkButtonText,
                                isButtonPressed('Home') && styles.linkButtonTextPressed
                            ]}>Home</Text>
                        </Pressable>
                        <Pressable
                            style={[
                                styles.linkButtonContainer,
                                isButtonPressed('Labels') && styles.linkButtonContainerPressed
                            ]}
                            onPressIn={() => handlePressIn('Labels')}
                            onPressOut={handlePressOut}
                        //onPress={() => navigation.navigate('Labels')}
                        >
                            <Text style={[
                                styles.linkButtonText,
                                isButtonPressed('Labels') && styles.linkButtonTextPressed
                            ]}>Labels</Text>
                        </Pressable>
                        <Pressable
                            style={[
                                styles.linkButtonContainer,
                                isButtonPressed('Folders') && styles.linkButtonContainerPressed
                            ]}
                            onPressIn={() => handlePressIn('Folders')}
                            onPressOut={handlePressOut}
                        //onPress={() => navigation.navigate('Folders')}
                        >
                            <Text style={[
                                styles.linkButtonText,
                                isButtonPressed('Folders') && styles.linkButtonTextPressed
                            ]}>Folders</Text>
                        </Pressable>
                        <Pressable
                            style={[
                                styles.linkButtonContainer,
                                isButtonPressed('Trash') && styles.linkButtonContainerPressed
                            ]}
                            onPressIn={() => handlePressIn('Trash')}
                            onPressOut={handlePressOut}
                        //onPress={() => navigation.navigate('Trash')}
                        >
                            <Text style={[
                                styles.linkButtonText,
                                isButtonPressed('Trash') && styles.linkButtonTextPressed
                            ]}>Trash</Text>
                        </Pressable>
                    </View>
                </Pressable>
            </Modal>
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
    modalOverlay: {
        flex: 1,
        justifyContent: 'flex-start',
        alignItems: 'flex-start',
        backgroundColor: 'rgba(0, 0, 0, 0.6)',
    },
    modalContainer: {
        width: "70%",
        height: "100%",
        padding: 20,
        backgroundColor: 'white',
        alignItems: 'flex-start',
    },
    modalText: {
        fontSize: 18,
        textAlign: "left",
        marginBottom: 20,
    },
    linkButtonContainer: {
        padding: 10,
        backgroundColor: "#fff",
        marginBottom: 10,
        width: "90%",
    },
    linkButtonContainerPressed: {
        backgroundColor: "#9bb9e8",
    },
    linkButtonText: {
        color: "black",
        fontWeight: "600",
        fontSize: 20,
    },
    linkButtonTextPressed: {
        color: "#0763f2",
    },
    addNoteButton: {
        position: "absolute",
        bottom: 20,
        right: 20,
        width: 50,
        height: 50,
        borderRadius: 50,
        backgroundColor: "#2483f2",
        justifyContent: "center",
        alignItems: "center",
    },
    addNoteIcon: {
        color: "#fff",
        fontSize: 30,
    },
});

AppRegistry.registerComponent('main', () => AddNote);

export default AddNote;
