import { View, StyleSheet, Text } from 'react-native';
import LabelTag from './LabelTag';
import { LABELS } from '../data/dummy-data';

export default function LabelContainer({ note }) {
  function findLabelById(id) {
    return LABELS.find(label => label.id === id);
  }

  if (!note) {
    return (
      <View style={styles.container}>
        <Text>Note not found!</Text>
      </View>
    );
  }

  return (
    <View style={styles.labelContainer}>
      {note.labelIds.map(labelId => {
        const label = findLabelById(labelId);
        return <LabelTag key={labelId} label={label} isPressable={false} />;
      })}
    </View>
  );
}

const styles = StyleSheet.create({
  labelContainer: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    marginBottom: 5,
  },
});
