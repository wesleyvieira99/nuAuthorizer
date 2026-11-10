#!/usr/bin/env bash
set -e

case "$1" in
  test)
    mvn test
    ;;
  *)
    mvn -q compile exec:java
    ;;
esac