import React from 'react';
import { Text, StyleSheet, Pressable, View } from "react-native";
import PropTypes from "prop-types";

const LabelTag = ({ label, isPressable, onPress }) => {
  if (!label) return null; // Handle cases where label is not found

  return isPressable ? (
    <Pressable onPress={onPress} style={styles.tag}>
      <Text style={styles.text}>{label.label}</Text>
    </Pressable>
  ) : (
    <View style={styles.tag}>
      <Text style={styles.text}>{label.label}</Text>
    </View>
  );
};

LabelTag.propTypes = {
  label: PropTypes.shape({
    id: PropTypes.string.isRequired,
    label: PropTypes.string.isRequired,
  }),
  onPress: PropTypes.func,
  isPressable: PropTypes.bool,
};

const styles = StyleSheet.create({
  tag: {
    padding: 5,
    borderRadius: 5,
    flexWrap: "wrap",
    margin: 5,
    alignSelf: "flex-start",
    backgroundColor: '#709be0',
  },
  text: {
    fontSize: 12,
    color: 'white'
  },
});

export default LabelTag;