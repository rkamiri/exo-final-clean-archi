#!/bin/bash
JUNITPATH="/usr/share/java/junit4-4.11.jar"
TESTCLASSES=$(find projet/src/test/* | grep .class$)
EXT="class"
CLASSNAMES=${TESTCLASSES%.$EXT}
echo "BEFORE: $CLASSNAMES"
DOTS=${CLASSNAMES//\//.}
echo AFTER: $DOTS
java -cp .:$JUNITPATH org.junit.runner.JUnitCore $DOTS