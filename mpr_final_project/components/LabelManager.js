import React, { useState } from 'react';
import { StyleSheet, View } from 'react-native';
import ManageLabel from '../screens/ManageLabels.js';
import Label from '../screens/Labels.js';
import { LABELS, NOTES, TRASH } from '../data/dummy-data';

const LabelManager = ({ children }) => {
  const [notes, setNote] = useState(NOTES);
  const [trash, setTrash] = useState(TRASH);

  const props = {
    notes,
    setNote,
    trash,
    setTrash,
  };

  return (
    <View style={styles.container}>
      {React.Children.map(children, child => {
        return React.cloneElement(child, props);
      })}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
});

export default LabelManager;
