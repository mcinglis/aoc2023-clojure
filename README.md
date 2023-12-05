# Advent of Code 2023 - Clojure

This repository contains [Advent of Code 2023][aoc2023] solutions in
[Clojure][].

- [`src/`](/src/au/id/minglis/aoc2023) contains the solution code.
- [`test/`](/test/au/id/minglis/aoc2023) contains the solution tests.
- [`resources/`](/resources/) contains the problems' input data.

For tooling, this project uses:

- a [tasks](/tasks) script for providing common project commands, such as
  `./tasks build` and `./tasks run`; run just `./tasks` for help.
- a [Containerfile](/Containerfile) providing a reference build environment.
- a [deps.edn](/deps.edn) file per [Clojure's Deps functionality][clojure-deps]
  for specifying `clj` CLI aliases like `main` and `test`.
- [cognitect.test-runner][test-runner] for discovering and running the tests.

Example interaction:

```
$ ./tasks

$ ./tasks build
...
Ran 6 tests containing 14 assertions.
0 failures, 0 errors.
...
Successfully tagged minglis.id.au/aoc2023-clojure:latest
8f08acb2c9b479fa02a4876f2ef19bf49324d0c6b6a830b5570d80fa545c64fa

$ ./tasks run
Day 2: [2541 66016]
Day 1: [55538 54875]
```

[aoc2023]: https://adventofcode.com/2023
[clojure]: https://clojure.org/
[clojure-deps]: https://clojure.org/guides/deps_and_cli
[test-runner]: https://github.com/cognitect-labs/test-runner

## Todo

- [ ] Catch up on advent problems.
- [ ] Set up linting, run on build.
- [ ] Set up GitHub/GitLab workflows.
- [ ] Review other Clojure AoC 2023 solutions.

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
