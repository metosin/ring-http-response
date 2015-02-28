# ring-http-response [![Build Status](https://travis-ci.org/metosin/ring-http-response.png?branch=master)](https://travis-ci.org/metosin/ring-http-response) [![Dependencies Status](http://jarkeeper.com/metosin/ring-http-response/status.png)](http://jarkeeper.com/metosin/ring-http-response)

Handling real HTTP Statuses with Clojure(Script), originally ported from the awesome [Spray](http://spray.io/).
Mostly a drop-in-place replacement for `ring.util.response`.

## Latest version

[![Clojars Project](http://clojars.org/metosin/ring-http-response/latest-version.svg)](http://clojars.org/metosin/ring-http-response)

## Usage

### Generating http responses

Functions take either a `body`, `url` or nothing as parameters in align to the [spec](http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html).

```clojure
(require '[ring.util.http-response :refer :all])

(continue)
; {:status 100, :headers {}, :body ""}

(ok "body")
; {:status 200, :headers {}, :body "body"}

(found "url")
; {:status 302, :headers {"Location" "url"}, :body ""}
```

### Asserting http responses

Available for both Clojure & ClojureScript.

``clojure
(require '[ring.util.http-predicates :as hp])

(hp/ok? {:status 200})
; true

(hp/not-found? {:status 404})
; true
```

### Status codes & documentation

For referring http codes by name & api docs like [Swagger](https://github.com/metosin/ring-swagger).

```clojure
(require '[ring.util.http-status :as hs])

hs/ok
; 200

hs/not-found
; 404

(hs/status 500)
; {:name "Internal Server Error"
;  :description "There was an internal server error."}
```

### Throwing error responses

All response functions for http error response have a exception throwing sibling with a bang in the name
(`bad-request` & `bad-request!`). These functions [Slingshot](https://github.com/scgilardi/slingshot) the
response wrapped in an `ExceptionInfo`.

```clojure
(bad-request "fail")
; {:status 400, :headers {}, :body "fail"}

(bad-request! "fail")
; clojure.lang.ExceptionInfo: throw+: {:type :ring.util.http-response/response, :response {:status 400, :headers {}, :body "fail"}}
```

There is also a `throw!` function to slingshot any kind response in an exception.

```clojure
(throw! (header (bad-request "body") "header" "value"))
; clojure.lang.ExceptionInfo: throw+: {:type :ring.util.http-response/response, :response {:status 400, :headers {"header" "value"}, :body "body"}}
```

### Catching thrown http responses

Mounting `ring.middleware.http-response/wrap-http-response` catches thrown http-responses and returns the responses within.
See the [facts](https://github.com/metosin/ring-http-response/blob/master/test/ring/middleware/http_response_test.clj) for examples.

## Migrating from ring.util.response
1. add the dependency
2. change your imports from `ring.util.response` to `ring.util.http-response`
3. convert your responses to use the correct http-terms:
   - 200: `response` => `ok`
   - 302: `redirect` => `found`
   - 303: `redirect-after-post` => `see-other`
4. enjoy

`created` and `not-found` are same in both packages. Also rest of the public vars in `ring.util.response` are available via `ring.util.http-response`.
These include: `status`, `header` `file-response`, `content-type`, `charset`, `set-cookie`,
`response?`, `url-response`, `resource-response` and `get-header`.

## License
Original [code](https://github.com/spray/spray/blob/master/spray-http/src/main/scala/spray/http/StatusCode.scala): Copyright © 2011-2013 the spray project <http://spray.io>.

Copyright © 2014-2015 [Metosin Oy](http://www.metosin.fi)

Distributed under the Eclipse Public License, the same as Clojure.
