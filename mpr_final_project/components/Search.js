import React, { useState } from 'react';
import { View, TextInput, Button, Text, StyleSheet, Pressable } from 'react-native';

const Search = ({ labels, onSearch, onCreateLabel }) => {
    const [searchTerm, setSearchTerm] = useState('');

    const handleSearch = () => {
        const filteredLabels = labels.filter((label) =>
            label.label.toLowerCase().includes(searchTerm.toLowerCase())
        );
        onSearch(filteredLabels);
    };

    return (
        <View style={styles.searchContainer}>
            <View style={styles.searchBar}>
                <TextInput
                    style={styles.searchInput}
                    value={searchTerm}
                    onChangeText={(text) => setSearchTerm(text)}
                    placeholder="Search or create label..."
                />
                <Button title="Search" onPress={handleSearch} />
            </View>
            <View style={styles.createLabelContainer}>
                <Pressable onPress={() => onCreateLabel(searchTerm)}>
                    <Text style={styles.createLabelText}>+ Create label {searchTerm}</Text>
                </Pressable>
            </View>
        </View>
    );
};

const styles = StyleSheet.create({
    searchContainer: {
        justifyContent: 'flex-start',
        alignItems: 'center',
        flexDirection: 'column',
        marginTop: 140,
        marginBottom: 20,
    },
    searchBar: {
        flexDirection: 'row',
    },
    searchInput: {
        width: '75%',
        height: 40,
        borderColor: 'gray',
        borderWidth: 1,
        padding: 10,
    },
    createLabelContainer: {
        marginTop: 10,
    },
    createLabelText: {
        color: 'blue',
        textDecorationLine: 'underline',
    },
});

export default Search;