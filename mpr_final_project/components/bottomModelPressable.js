import React from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import PropTypes from 'prop-types';

const BottomPressable = ({ iconName, text, onPress }) => {
    return (
        <TouchableOpacity onPress={onPress} style={styles.button}>
            <View style={styles.container}>
                <Ionicons name={iconName} size={16} style={styles.icon} />
                <Text style={styles.text}>{text}</Text>
            </View>
        </TouchableOpacity>
    );
};

BottomPressable.propTypes = {
    iconName: PropTypes.string.isRequired,
    text: PropTypes.string.isRequired,
    onPress: PropTypes.func.isRequired,
};

const styles = StyleSheet.create({
    button: {
        backgroundColor: "#fff",
        padding: 10,
    },
    container: {
        flexDirection: 'row',
        alignItems: 'center',
    },
    icon: {
        color: "#000",
    },
    text: {
        marginLeft: 8,
        color: "#000",
        fontSize: 12,
    },
});

export default BottomPressable;
