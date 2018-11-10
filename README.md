# ring-http-response [![Build Status](https://travis-ci.org/metosin/ring-http-response.svg?branch=master)](https://travis-ci.org/metosin/ring-http-response)

Handling HTTP Statuses with Clojure(Script), originally ported from the awesome [Spray](http://spray.io/).
Mostly a drop-in-place replacement for `ring.util.response`.

## Latest version

[![Clojars Project](http://clojars.org/metosin/ring-http-response/latest-version.svg)](http://clojars.org/metosin/ring-http-response)

## Usage

### Generating HTTP responses

Functions take either a `body`, `url`, both or nothing as parameters in align to the [spec](http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html).

```clojure
(require '[ring.util.http-response :refer :all])

(continue)
; {:status 100, :headers {}, :body ""}

(ok "body")
; {:status 200, :headers {}, :body "body"}

(created "url" "body")
; {:status 201, :headers {"Location" "url"}, :body "body"}

(found "url")
; {:status 302, :headers {"Location" "url"}, :body ""}
```

### Asserting HTTP responses

Available for both Clojure & ClojureScript.

```clojure
(require '[ring.util.http-predicates :as predicates])

(predicates/ok? {:status 200})
; true

(predicates/not-found? {:status 404})
; true
```

### Status codes & documentation

For referring HTTP codes by name & for api docs like [Swagger](https://github.com/metosin/ring-swagger).

```clojure
(require '[ring.util.http-status :as status])

status/ok
; 200

status/not-found
; 404

(status/get-name 404)
; "Not Found"

(status/get-description 404)
; "The requested resource could not be found but may be available again in the future."

(status/status 404)
; {:name "Not Found"
;  :description "The requested resource could not be found but may be available again in the future."}
```

### Throwing error responses

All response functions for HTTP error response have a exception throwing sibling with a bang in the name
(`bad-request` & `bad-request!`). These functions throw the
response wrapped in an `ExceptionInfo`.

```clojure
(bad-request "fail")
; {:status 400, :headers {}, :body "fail"}

(bad-request! "fail")
; clojure.lang.ExceptionInfo: throw: {:type :ring.util.http-response/response, :response {:status 400, :headers {}, :body "fail"}}
```

There is also a `throw!` function to throw any kind response in an exception.

```clojure
(throw! (header (bad-request "body") "header" "value"))
; clojure.lang.ExceptionInfo: throw: {:type :ring.util.http-response/response, :response {:status 400, :headers {"header" "value"}, :body "body"}}
```

### Catching thrown HTTP responses

Middleware `ring.middleware.http-response/wrap-http-response` catches thrown HTTP-responses and returns the responses within.
See the [facts](https://github.com/metosin/ring-http-response/blob/master/test/ring/middleware/http_response_test.clj) for examples.

## Migrating from ring.util.response
1. add the dependency
2. change your imports from `ring.util.response` to `ring.util.http-response`
3. convert your responses to use the correct HTTP-terms:
   - 200: `response` => `ok`
   - 302: `redirect` => `found`
   - 303: `redirect-after-post` => `see-other`
4. enjoy

`created` and `not-found` are same in both packages. Also rest of the public vars in `ring.util.response` are available via `ring.util.http-response`.
These include: `status`, `header`, `file-response`, `content-type`, `find-header`, `get-header`, `update-header`, `charset`, `set-cookie`, `response?`
`resource-data`, `url-response` and `resource-response`.

## License
Original [code](https://github.com/spray/spray/blob/master/spray-http/src/main/scala/spray/http/StatusCode.scala): Copyright © 2011-2013 the spray project <http://spray.io>.

Copyright © 2014-2017 [Metosin Oy](http://www.metosin.fi)

Distributed under the Eclipse Public License, the same as Clojure.
