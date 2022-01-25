#!/bin/sh

set -Eeou pipefail

function checkForCheckstyle {
  command -v checkstyle >/dev/null 2>&1
}

function printNoCheckstyleAndExit {
  echo "You don't have checkstyle installed. You can get it with \`brew install checkstyle\`" && exit 1

}

checkForCheckstyle || printNoCheckstyleAndExit

echo "Running Git Pre-Commit Hook"
