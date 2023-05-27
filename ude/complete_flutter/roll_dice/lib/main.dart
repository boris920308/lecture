import 'package:flutter/material.dart';
import 'package:roll_dice/gradient_container.dart';

void main() {
  runApp(
    const MaterialApp(
      home: Scaffold(
        // backgroundColor: Color.fromARGB(255, 12, 58, 59),
        body: GradientContainer(
          Color.fromARGB(255, 102, 107, 100),
          Color.fromARGB(255, 204, 219, 221),
        ),
      ),
    ),
  );
}
