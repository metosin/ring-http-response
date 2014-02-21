# ring-http-response

[![Build Status](https://travis-ci.org/metosin/ring-http-response.png?branch=master)](https://travis-ci.org/metosin/ring-http-response)

Real HTTP Statuses for Ring. Ported from the awesome [Spray](http://spray.io/).

## Latest version

[![Latest version](https://clojars.org/metosin/ring-http-response/latest-version.svg)](https://clojars.org/metosin/ring-http-response)

## Usage

Check out the [facts](https://github.com/metosin/ring-http-response/blob/master/test/ring/util/http_response_test.clj).

## Throwing error responses

Sometimes it's convenient to short-circuit the execution by throwing an exception. All http-responses have a sibling functions with `!`int the end of the name (`not-found` & `not-found!`). These functions [Slingshot](https://github.com/scgilardi/slingshot) the response, which can be caught in a middeware and demoted back to a response.

For this purpose, there is `ring.middleware.http-response/catch-response`. It consumes only http-response-exceptions and by so can be after any other exception-catching middleware. See [facts](https://github.com/metosin/ring-http-response/blob/master/test/ring/middleware/http_response_test.clj).

## Migrating from ring.util.response
1. add the dependency
2. change your imports from `ring.util.response` to `ring.util.http-response`
3. convert your responses to use the correct http-terms:
   - 200: `response` => `ok`
   - 302: `redirect` => `found`
   - 303: `redirect-after-post` => `see-other`
4. enjoy

`created` and `not-found` are same in both packages. Also rest of the `ring.util.response` public functions are imported to the `ring.util.http-response`. These include: `status`, `header` `file-response`, `content-type`, `charset`, `set-cookie`, `response?`, `url-response`, `resource-response` and `get-header`.

## License

Original [code](https://github.com/spray/spray/blob/master/spray-http/src/main/scala/spray/http/StatusCode.scala): Copyright © 2011-2013 the spray project <http://spray.io>.

Copyright © 2014 Metosin Oy

Distributed under the Eclipse Public License, the same as Clojure.
