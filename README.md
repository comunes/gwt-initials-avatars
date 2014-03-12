gwt-initials-avatars
====================

This project has several utilities for generating initials avatars inspired in Gmail Android App.

It includes a Servlet that can generate random initials avatars from URLs of this form `http://localhost:8080/iniavatars/100x100/blisset` for get a PNG avatar of 100px with a "B".

Also it includes a GWT library to do the same thing in client side and for composite several avatars in one.

This project was generated with [Maven archetypes for modular GWT projects](https://github.com/tbroyer/gwt-maven-archetypes)

### Use SuperDevMode

Change directory to your generated project and issue the following commands:

1. `mvn clean install -Dgwt.draftCompile`
2. In one terminal window: `cd *-client && mvn process-classes gwt:run-codeserver -Ddev`
3. In another terminal window: `mvn tomcat7:run -Ddev`

The same is available with `tomcat6` instead of `tomcat7`.

Or if you'd rather use Jetty than Tomcat, use `cd *-server && mvn jetty:start -Ddev` instead of `mvn tomcat7:run`.

Note that you only need to `install` once so that `gwt:run-codeserver` and `jetty:start`
can find the other modules. This is currently needed because neither `gwt:run`
nor `jetty:start` support running in reactor builds, contrary to `tomcat7:run`.

The `-Dgwt.draftCompile` in the first step is not required, it's only to speed up the GWT compilation by disabling optimizations.

### Start the development mode

This is similar to using SuperDevMode, except you can use `-Dgwt.compiler.skip`
instead of `-Dgwt.draftCompile` to speed up the first step (it only has to be done once
though so it's probably no big deal), and more importantly you'll use `mvn gwt:run`
instead of `mvn process-classes gwt:run-codeserver` (`process-classes` is only needed
because of a bug in the `gwt-maven-plugin` up until version 2.6.0).

Steps therefore become:

1. `mvn clean install -Dgwt.compiler.skip`
2. In one terminal window: `cd *-client && mvn gwt:run -Ddev`
3. In another terminal window: `mvn tomcat7:run -Ddev`


### Profiles

There's a special profile defined in the POM file of client and server modules:
`dev`, which is used only when developping. It configures the Tomcat and Jetty
plugins and speeds up development with `gwt:run-codeserver`, `gwt:run` and
`jetty:start` by not requiring a restart when a change to the
`${rootArtifactId}-shared` is made.

To activate the `dev` profile you can provide the `-Ddev` system property, or
use `-Pdev`.

### Productivity tips

When working on the server-side code exclusively, you don't need GWT's DevMode.
You can then compile the GWT app using `mvn package` or `mvn package -Dgwt.draftCompile`
and then `mvn tomcat7:run` or `cd *-server && mvn jetty:start -Ddev`. The
webapp will be redeployed automatically when you change a class (either
compiled by your IDE, or by `mvn compile`) in either the
`${rootArtifactId}-server` or `${rootArtifactId}-shared` module (be careful
though when changing classes in `shared` that you do not break the GWT client
code, particularly when using GWT-RPC).

When working on the client-side code exclusively, to quickly test it in a
browser in production mode, use `mvn package -Dgwt.draftCompile`. You can use
`mvn package -Dgwt.draftCompile -pl :${rootArtifactId}-client -am` while the
Tomcat or Jetty server is running (launched by `mvn tomcat7:run` or
`cd *-server && mvn jetty:start -Ddev`), and then simply hit `F5` in your browser.
