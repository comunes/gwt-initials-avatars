package cc.kune.initials;

import cc.kune.initials.InitialsResources.InitialsCss;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class InitialsEntryPoint implements EntryPoint {
  @Override
  public void onModuleLoad() {
    final InitialsCss css = InitialsResources.INS.css();
    css.ensureInjected();
    new InitialsAvatarsTest();
  }
}
