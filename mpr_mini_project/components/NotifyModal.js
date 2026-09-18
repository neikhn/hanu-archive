import { StyleSheet, Pressable, View, Text, Modal } from "react-native";

export default function NotifyModal({ visible, onClose, children, buttonContent }) {
  return (
    <Modal
      visible={visible}
      onRequestClose={onClose}
      animationType="fade"
      transparent={true}
    >
      <View style={styles.modalOverlay}>
        <View style={styles.modalContainer}>
          <Text style={styles.modalText}>{children}</Text>
          <Pressable
            style={styles.closeButtonContainer}
            onPress={onClose}
          >
            <Text style={styles.closeButtonText}>{buttonContent}</Text>
          </Pressable>
        </View>
      </View>
    </Modal>
  );
};

const styles = StyleSheet.create({
  modalOverlay: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'rgba(0, 0, 0, 0.5)',
  },
  modalContainer: {
    width: 300,
    padding: 20,
    backgroundColor: 'white',
    borderRadius: 20,
    alignItems: 'center',
  },
  modalText: {
    fontSize: 18,
    textAlign: "center",
    marginBottom: 20,
  },
  closeButtonContainer: {
    padding: 10,
    backgroundColor: "#5E6EFC",
    borderRadius: 15,
  },
  closeButtonText: {
    color: "white",
    fontWeight: "600",
    fontSize: 20,
  },
});