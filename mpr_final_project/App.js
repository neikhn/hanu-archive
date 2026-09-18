import React from 'react';
import { StyleSheet } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { createDrawerNavigator } from '@react-navigation/drawer';
import Ionicons from 'react-native-vector-icons/Ionicons';
import Labels from './screens/Labels';
import Home from "./screens/Home.js";
import NewNote from "./screens/NewNote.js";
import EditNote from './screens/EditNote.js';
import ManageLabels from './screens/ManageLabels';
import Trash from './screens/Trash.js';

const Stack = createNativeStackNavigator();
const Drawer = createDrawerNavigator();

function MainDrawerNavigator() {
  return (
    <Drawer.Navigator initialRouteName="Home" >
      <Drawer.Screen
        name="Home"
        component={Home}
        options={{
          drawerIcon: ({ size, color }) => (
            <Ionicons name="home" size={size} color={color} />
          ),
        }}
      />
      <Drawer.Screen
        name="Labels"
        component={Labels}
        options={{
          drawerIcon: ({ size, color }) => (
            <Ionicons name="pricetag" size={size} color={color} />
          ),
        }}
      />
      <Drawer.Screen
        name="Trash"
        component={Trash}
        options={{
          drawerIcon: ({ size, color }) => (
            <Ionicons name="trash" size={size} color={color} />
          ),
        }}
      />
    </Drawer.Navigator>
  );
}

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Drawer" options={{ headerShown: false }} component={MainDrawerNavigator} />
        <Stack.Screen name="New note" component={NewNote} />
        <Stack.Screen name="Manage labels" component={ManageLabels} />
        <Stack.Screen name="Edit note" component={EditNote} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
});
