## 0.9.5 (unreleased)

**BREAKING**: Header names are now lowercase to comply with Ring Spec (1.5)
- Changed "Location" header to "location" in redirect and creation responses

## 0.9.4 (29.6.2024)

- add teapot functionality [#33](https://github.com/metosin/ring-http-response/pull/33)
- updated dependencies:

```clojure
[ring/ring-core "1.12.2"] is available but we use "1.10.0"
[potemkin "0.4.7"] is available but we use "0.4.5"
```

## 0.9.3 (25.8.2021)

- updated dependencies:

```
[ring/ring-core "1.9.4"]
```

## 0.9.2 (4.2.2021)

- updated dependencies:

```
[ring/ring-core "1.9.0"] is available but we use "1.7.1"
```

## 0.9.1 (10.11.2018)

- updated dependencies:

```
[ring/ring-core "1.7.1"] is available but we use "1.6.0"
[potemkin "0.4.5"] is available but we use "0.4.3"
```

## 0.9.0 (10.5.2017)

- require `[ring/ring-core "1.6.0"]`
  - `get-charset` added to `ring.util.http-response`
- run tests with Clojure `1.9.0-alpha16`
- updated dependencies:

```
[ring/ring-core "1.6.0"] is available but we use "1.5.1"
```

## 0.8.2 (8.2.2017)

- Add ring-async support to `ring.middleware.http-response/wrap-http-response`
- Use `ex-info` & `ex-data` instead of slingshot in exceptions

- removed dependencies:

```clj
[slingshot "0.12.2"]
```

## 0.8.1 (11.1.2017)

- Update Ring to [avoid a path traversal vulnerability](https://groups.google.com/forum/#!topic/clojure/YDrKBV26rnA).

```clj
[ring/ring-core "1.5.1"] is available but we use "1.5.0"
```

## 0.8.0 (28.6.2016)

- **BREAKING**: first argument for `created` is `url`, not `body`. Has 2-arity version which takes both `url` & `body` in align to the [spec](http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html) & [ring](https://github.com/ring-clojure/ring/blob/master/ring-core/src/ring/util/response.clj#L37)
   - fixes [#12](https://github.com/metosin/ring-http-response/issues/12).

## 0.7.0 (13.6.2016)

- Test with Clojure 1.7.0 & 1.8.0
- Better imports of `ring.util.response` -> `ring.util.http-response` (fail with informative message if old version of Ring is used)
- update dependencies

```clj
[ring/ring-core "1.5.0"] is available but we use "1.4.0"
[potemkin "0.4.3"] is available but we use "0.4.1"
```

## 0.6.5 (1.9.2016)

- import only extra ring vars if they exist, so that the ns compiles with non-latest ring.

## 0.6.4 (21.8.2016)

- import new functions from ring 1.4.0: `find-header`, `get-header`, `resource-data`
- update dependencies:

```clojure
[ring/ring-core "1.4.0"] is available but we use "1.3.2"
[potemkin "0.4.1"] is available but we use "0.3.13"
[stencil "0.5.0"] is available but we use "0.3.5"
[midje "1.7.0"] is available but we use "1.6.3"
```

## 0.6.3 (8.7.2015)

- Added predicates for HTTP status types (classes) such as `success?`, `client-error?` and `server-error?`

## 0.6.2 (20.5.2015)

- added `get-name` and `get-description` to status-ns.
- update dependencies

```clojure
[potemkin "0.3.13"] is available but we use "0.3.11"
```

## 0.6.1 (11.3.2015)

- generate also `ring.util.http-predicates` for ClojureScript.

## 0.6.0 (1.3.2015)

- move from macro-based compile-time code-generation into mustache-based pre-compile code generation
  (big thanks to [@frankiesardo](https://github.com/frankiesardo)!)
- FIXES
  - [#2](https://github.com/metosin/ring-http-response/issues/2) new namespace `ring.util.http-status`
  - [#3](https://github.com/metosin/ring-http-response/issues/3) `(user/generate!)`
  - [#5](https://github.com/metosin/ring-http-response/issues/5) `ring.util.http-predicates`
- **Breaking changes:**:
  - `reset-content` takes no body
  - `blocked-by-parental-control` => `blocked-by-windows-parental-controls`
  - `ring.middleware.http-response/catch-response` => `ring.middleware.http-response/wrap-http-response`
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
