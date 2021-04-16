import React, { useState } from 'react';
import { Button, NativeModules, Text, View } from 'react-native';

const Module = () => {
    const { Module } = NativeModules;
    const [result, setResult] = useState(false);
    const sdkVersion = Module.getSdkVersion();
    
    const onPress = () => {
        Module.init(result => {
            setResult(result);
        });
    };
    return (
        <View>
            <Text>SDK Version: {sdkVersion}</Text>
            <Text>결과: {result.toString()}</Text>
            <Button onPress={onPress} title="Init"/>
        </View>
    );
}

export default Module;