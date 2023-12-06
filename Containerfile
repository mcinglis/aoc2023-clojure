
FROM registry.fedoraproject.org/fedora:39

# Update and install Clojure and other build dependencies:
RUN \
  dnf -y update && \
  dnf -y install \
    bash \
    curl \
    git \
    java-latest-openjdk-headless \
    rlwrap && \
  dnf -y clean all

# Install Clojure (per https://clojure.org/guides/install_clojure):
RUN \
  curl -L -O https://github.com/clojure/brew-install/releases/latest/download/linux-install.sh && \
  chmod +x linux-install.sh && \
  ./linux-install.sh && \
  clojure --version

WORKDIR /app

COPY deps.edn .
RUN clojure -P -T:repl:test

COPY . .

RUN \
  clojure -X:test && \
  echo && \
  clojure -X:main

CMD clojure -X:main
