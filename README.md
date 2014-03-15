# ring-http-response

[![Build Status](https://travis-ci.org/metosin/ring-http-response.png?branch=master)](https://travis-ci.org/metosin/ring-http-response)

Real HTTP Statuses for Ring. Ported from the awesome [Spray](http://spray.io/).

## Latest version

```clojure
[metosin/ring-http-response 0.4.0]
```

## Usage

This library covers most/all of the available (http-statuses)[http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html] as response generating functions. These functions take either a `body`, `url` or no parameter to meet the requirements of the http spec.

Check out the [facts](https://github.com/metosin/ring-http-response/blob/master/test/ring/util/http_response_test.clj).

### Returning http responses

```clojure
(use 'ring.util.http-response)

(continue)
; {:status 100, :headers {}, :body ""}

(ok "body")
; {:status 200, :headers {}, :body "body"}

(found "url")
; {:status 302, :headers {"Location" "url"}, :body "<a href=\"url\">url</a>"}
```

### documentation

```clojure
(doc temporary-redirect)
; -------------------------
; ring.util.http-response/temporary-redirect
; ([url])
;   307 TemporaryRedirect (Redirection)
;
; The request should be repeated with another URI but future requests can still use the original URI.

(doc bad-request)
; -------------------------
; ring.util.http-response/bad-request
; ([body])
;   400 BadRequest (ClientError)
;
; The request contains bad syntax or cannot be fulfilled.
```
### Throwing error responses

All erronous http-response generating functions have a exception throwing sibligs with a bang in their name (`bad-request` & `bad-request!`). These functions [Slingshot](https://github.com/scgilardi/slingshot) the response, which can be caught in a middeware and demoted back to a response.

```clojure
(bad-request "kosh")
; {:status 400, :headers {}, :body "kosh"}

(bad-request! "kosh")
; ExceptionInfo throw+: {:type :ring.util.http-response/response, :response {:status 400, :headers {}, :body "kosh"}}  ring.util.http-response/throw! (http_response.clj:24)
```

There is also a `throw!` function which throws the given response. It can be used when one needs to set also headers etc. for the response

```clojure
(throw! (header (bad-request "body") "header" "value"))
; ExceptionInfo throw+: {:type :ring.util.http-response/response, :response {:status 400, :headers {"header" "value"}, :body "body"}}  ring.util.http-response/throw! (http_response.clj:24)
```

### Managing thrown responses

There is a ready middleware to handle just the thrown responses - `ring.middleware.http-response/catch-response`. See [facts](https://github.com/metosin/ring-http-response/blob/master/test/ring/middleware/http_response_test.clj) for more info.

## Migrating from ring.util.response
1. add the dependency
2. change your imports from `ring.util.response` to `ring.util.http-response`
3. convert your responses to use the correct http-terms:
   - 200: `response` => `ok`
   - 302: `redirect` => `found`
   - 303: `redirect-after-post` => `see-other`
4. enjoy

`created` and `not-found` are same in both packages. Also rest of the `ring.util.response` public functions are available via `ring.util.http-response`. These include: `status`, `header` `file-response`, `content-type`, `charset`, `set-cookie`, `response?`, `url-response`, `resource-response` and `get-header`.

## License
Original [code](https://github.com/spray/spray/blob/master/spray-http/src/main/scala/spray/http/StatusCode.scala): Copyright © 2011-2013 the spray project <http://spray.io>.

Copyright © 2014 Metosin Oy

Distributed under the Eclipse Public License, the same as Clojure.
