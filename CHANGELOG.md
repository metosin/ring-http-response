## 0.6.0 (28.2.2015)

- move from macro-based compile-time code-generation into mustache-based pre-compile code generation
  (big thanks to @frankiesardo!)
- FIXES
  - #2 new namespace `ring.util.http-status`
  - #3 `(user/generate!)`
  - #5 `ring.util.http-predicates` 
- **Breaking:**:
  - `reset-content` takes no body
  - `blocked-by-parental-control` => `blocked-by-windows-parental-controls`
- removed dependencies:
```clojure
[org.tobereplaced/lettercase "1.0.0"]
```
- updated dependencies:
```clojure
[ring/ring-core "1.3.2"] is available but we use "1.3.1"
[slingshot "0.12.2"] is available but we use "0.11.0"
[potemkin "0.3.11"] is available but we use "0.3.9"
```

## 0.5.2 (11.11.2014)

- use `[org.tobereplaced/lettercase "1.0.0"]` for camel-casing

## 0.5.1 (14.10.2014)

- Remove body from redirect responses (#4), thanks to [Joe Littlejohn](https://github.com/joelittlejohn).
- updated dependencies:

```clojure
[slingshot "0.11.0"] is available but we use "0.10.3"
[potemkin "0.3.9"] is available but we use "0.3.8"
```

## 0.5.0 (4.9.2014)

- updated dependencies:

```clojure
[ring/ring-core "1.3.1"]
[potemkin "0.3.8"]
[camel-snake-kebab "0.2.4"]
```
- Camel\_SNAKE-kebab 0.2.0 renamed the ns camel-snake-kebab to camel-snake-kebab.core

## 0.4.1 (15.7.2014)

- updated dependencies:

```clojure
[org.clojure/clojure "1.6.0"]
[ring/ring-core "1.3.0"]
[camel-snake-kebab "0.1.5"]
[midje "1.6.3"]
```

## 0.4.0 (15.3.2014)

- Added `throw!` to throw any http-response
- Fixed documentation bug
- New Docs

## 0.3.0 (13.2.2014)

- Initial public version
