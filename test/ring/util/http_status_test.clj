(ns ring.util.http-status-test
  (:require [midje.sweet :refer :all]
            [ring.util.http-status :refer :all]))


(facts "http-statusses"

  (facts "Informational"
    continue                               => 100
    switching-protocols                    => 101
    processing                             => 102)

  (facts "Success"
    ok                                     => 200
    created                                => 201
    accepted                               => 202
    non-authoritative-information          => 203
    no-content                             => 204
    reset-content                          => 205
    partial-content                        => 206
    multi-status                           => 207
    already-reported                       => 208
    im-used                                => 226)

  (facts "Redirection"
    multiple-choices                       => 300
    moved-permanently                      => 301
    found                                  => 302
    see-other                              => 303
    not-modified                           => 304
    use-proxy                              => 305
    temporary-redirect                     => 307
    permanent-redirect                     => 308)

  (facts "ClientError"
    bad-request                            => 400
    unauthorized                           => 401
    payment-required                       => 402
    forbidden                              => 403
    not-found                              => 404
    method-not-allowed                     => 405
    not-acceptable                         => 406
    proxy-authentication-required          => 407
    request-timeout                        => 408
    conflict                               => 409
    gone                                   => 410
    length-required                        => 411
    precondition-failed                    => 412
    request-entity-too-large               => 413
    request-uri-too-long                   => 414
    unsupported-media-type                 => 415
    requested-range-not-satisfiable        => 416
    expectation-failed                     => 417
    enhance-your-calm                      => 420
    unprocessable-entity                   => 422
    locked                                 => 423
    failed-dependency                      => 424
    unordered-collection                   => 425
    upgrade-required                       => 426
    precondition-required                  => 428
    too-many-requests                      => 429
    request-header-fields-too-large        => 431
    retry-with                             => 449
    blocked-by-windows-parental-controls   => 450
    unavailable-for-legal-reasons          => 451)

  (facts "ServerError"
    internal-server-error                  => 500
    not-implemented                        => 501
    bad-gateway                            => 502
    service-unavailable                    => 503
    gateway-timeout                        => 504
    http-version-not-supported             => 505
    variant-also-negotiates                => 506
    insufficient-storage                   => 507
    loop-detected                          => 508
    bandwidth-limit-exceeded               => 509
    not-extended                           => 510
    network-authentication-required        => 511
    network-read-timeout                   => 598
    network-connect-timeout                => 599))
