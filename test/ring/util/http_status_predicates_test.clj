(ns ring.util.http-status-predicates-test
  (:require [midje.sweet :refer :all]
            [ring.util.http-status-predicates :refer :all]))


(facts "http-statusses"

  (facts "Informational"
    {:status 100} => continue?
    {:status 101} => switching-protocols?
    {:status 102} => processing?)

  (facts "Success"
    {:status 200} => ok?
    {:status 201} => created?
    {:status 202} => accepted?
    {:status 203} => non-authoritative-information?
    {:status 204} => no-content?
    {:status 205} => reset-content?
    {:status 206} => partial-content?
    {:status 207} => multi-status?
    {:status 208} => already-reported?
    {:status 226} => im-used?)

  (facts "Redirection"
    {:status 300} => multiple-choices?
    {:status 301} => moved-permanently?
    {:status 302} => found?
    {:status 303} => see-other?
    {:status 304} => not-modified?
    {:status 305} => use-proxy?
    {:status 307} => temporary-redirect?
    {:status 308} => permanent-redirect?)

  (facts "ClientError"
    {:status 400} => bad-request?
    {:status 401} => unauthorized?
    {:status 402} => payment-required?
    {:status 403} => forbidden?
    {:status 404} => not-found?
    {:status 405} => method-not-allowed?
    {:status 406} => not-acceptable?
    {:status 407} => proxy-authentication-required?
    {:status 408} => request-timeout?
    {:status 409} => conflict?
    {:status 410} => gone?
    {:status 411} => length-required?
    {:status 412} => precondition-failed?
    {:status 413} => request-entity-too-large?
    {:status 414} => request-uri-too-long?
    {:status 415} => unsupported-media-type?
    {:status 416} => requested-range-not-satisfiable?
    {:status 417} => expectation-failed?
    {:status 420} => enhance-your-calm?
    {:status 422} => unprocessable-entity?
    {:status 423} => locked?
    {:status 424} => failed-dependency?
    {:status 425} => unordered-collection?
    {:status 426} => upgrade-required?
    {:status 428} => precondition-required?
    {:status 429} => too-many-requests?
    {:status 431} => request-header-fields-too-large?
    {:status 449} => retry-with?
    {:status 450} => blocked-by-windows-parental-controls?
    {:status 451} => unavailable-for-legal-reasons?)

  (facts "ServerError"
    {:status 500} => internal-server-error?
    {:status 501} => not-implemented?
    {:status 502} => bad-gateway?
    {:status 503} => service-unavailable?
    {:status 504} => gateway-timeout?
    {:status 505} => http-version-not-supported?
    {:status 506} => variant-also-negotiates?
    {:status 507} => insufficient-storage?
    {:status 508} => loop-detected?
    {:status 509} => bandwidth-limit-exceeded?
    {:status 510} => not-extended?
    {:status 511} => network-authentication-required?
    {:status 598} => network-read-timeout?
    {:status 599} => network-connect-timeout?))
