import 'package:flutter/material.dart';
import 'package:roll_dice/styled_text.dart';

const startAlignment = Alignment.topLeft;
// Alignment? startAlignment;
const endAlignment = Alignment.bottomRight;

class GradientContainer extends StatelessWidget {
  const GradientContainer(this.startColor, this.endColor, {super.key});
  final Color startColor;
  final Color endColor;

  @override
  Widget build(BuildContext context) {
    // startAlignment = Alignment.topLeft;

    return Container(
      decoration: BoxDecoration(
        gradient: LinearGradient(
          colors: [
            startColor,
            endColor,
          ],
          begin: startAlignment,
          end: endAlignment,
        ),
      ),
      child: const Center(
        child: StyledText('Hello World!'),
      ),
    );
    // throw UnimplementedError();
  }
}

// class GradientContainer extends StatelessWidget {

//   const GradientContainer({super.key, required this.colors});

//   final List<Color> colors;

//   @override
//   Widget build(BuildContext context) {
//     return Container(
//       decoration: BoxDecoration(
//         gradient: LinearGradient(
//           colors: colors,
//           begin: startAlignment,
//           end: endAlignment,
//         ),
//       ),
//       child: const Center(
//         child: StyledText('Hello World!'),
//       ),
//     );
//   }
// }
