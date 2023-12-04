# Advent of Code 2023 - Clojure

This repository contains [Advent of Code 2023][aoc2023] solutions in
[Clojure][].

- [`src/`](/src/) contains the solution code.
- [`test/`](/test/) contains the solution tests.
- [`resources/`](/resources/) contains the problems' input data.

For tooling, this project uses:

- a [tasks](/tasks) script for providing common project commands, such as
  `./tasks build` and `./tasks run`; run just `./tasks` for help.
- a [Containerfile](/Containerfile) providing a reference build environment.
- a [deps.edn](/deps.edn) file per [Clojure's Deps](clojure-deps) for
  specifying `clj` CLI aliases like `main` and `test`.
- [cognitect.test-runner][test-runner] for discovering and running the tests.

Example interaction:

```
$ ./tasks

$ ./tasks build
...
Ran 2 tests containing 2 assertions.
0 failures, 0 errors.
...
Successfully tagged minglis.id.au/aoc2023-clojure:latest
9cfa47f1f42ebf5f661422bc9257f960e3b858e3112ed17c3a3e2d451d208b1b

$ ./tasks run
Day 1: [55538]
```

[aoc2023]: https://adventofcode.com/2023
[clojure]: https://clojure.org/
[clojure-deps]: https://clojure.org/guides/deps_and_cli
[test-runner]: https://github.com/cognitect-labs/test-runner

## License

Copyright (C) 2023  Malcolm Inglis <me@minglis.id.au>

This software is free software: you can redistribute it and/or modify it under
the terms of the GNU Affero General Public License (version 3) as published by
the Free Software Foundation. A copy of that license is provided in the
[LICENSE](/LICENSE) file of this package. It is also available at:
<https://www.gnu.org/licenses/agpl-3.0.txt>

This software is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.

SPDX-License-Identifier: AGPL-3.0-only
