# ring-http-response

[![Build Status](https://travis-ci.org/metosin/ring-http-response.png?branch=master)](https://travis-ci.org/metosin/ring-http-response)

Real HTTP Statuses for Ring. Ported from the awesome [Spray](http://spray.io/).

## Installation

    [metosin/ring-http-response "0.2.0"]

## Usage

Check out the [facts](https://github.com/metosin/ring-http-response/blob/master/test/ring/util/http_response_test.clj).

## Migrating from ring.util.response
1. add the dependency
2. change your imports `ring.util.response` to `ring.util.http-response`
3. convert your responses to use the correct http-terms:
   - 200: `response` => `ok`
   - 201: `redirect` => `created`
   - 302: `redirect-after-post` => `see-other`
4. enjoy

`created` and `not-found` are same in both packages. Also rest of the `ring.util.response` public functions are imported to the `ring.util.http-response`. These include: `status`, `header` `file-response`, `content-type`, `charset`, `set-cookie`, `response?`, `url-response`, `resource-response` and `get-header`.

## License

Original [code](https://github.com/spray/spray/blob/master/spray-http/src/main/scala/spray/http/StatusCode.scala): Copyright © 2011-2013 the spray project <http://spray.io>.

Copyright © 2014 Metosin Oy

Distributed under the Eclipse Public License, the same as Clojure.
