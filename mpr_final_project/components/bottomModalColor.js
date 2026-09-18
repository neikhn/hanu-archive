import React from 'react';
import { View, TouchableOpacity, StyleSheet, Text } from 'react-native';
import PropTypes from 'prop-types';
import { COLORS } from '../data/dummy-data';
import Icon from 'react-native-vector-icons/Ionicons'; // Import Icon

const BottomModalColor = ({ onPress = () => {}, selectedColor = null }) => {
    const handleColorSelection = (color) => {
        onPress(color === 'null' ? null : color);
    };

    return (
        <View style={styles.colorContainer}>
            <TouchableOpacity
                style={[styles.colorCircle]}
                onPress={() => handleColorSelection('null')}
            >
                <Icon style={styles.bottomIcon} name="ban-outline" />
            </TouchableOpacity>
            {COLORS.map((color, index) => (
                <TouchableOpacity
                    key={index}
                    style={[styles.colorCircle, { backgroundColor: color, borderColor: color === selectedColor ? '#000' : 'transparent' }]}
                    onPress={() => handleColorSelection(color)}
                />
            ))}
        </View>
    );
};

const styles = StyleSheet.create({
    colorContainer: {
        flexDirection: 'row',
        justifyContent: 'flex-start',
        alignItems: 'center',
        marginBottom: 20,
    },
    colorCircle: {
        width: 20,
        height: 20,
        borderRadius: 25,
        margin: 5,
        opacity: 0.7,
    },
    bottomIcon: {
        fontSize: 20,
        color: '#000',
    },
});

BottomModalColor.propTypes = {
    onPress: PropTypes.func,
    selectedColor: PropTypes.string,
};

export default BottomModalColor;
