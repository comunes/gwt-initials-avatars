package cc.kune.initials;

import cc.kune.initials.AvatarComposite.Builder;
import cc.kune.initials.InitialsResources.InitialsCss;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class InitialsAvatarsTest implements EntryPoint {

  String[] NAMES = new String[] { "Simone", "Luther", "Bertrand", "Ada", "Martin", "吗 台湾", "واعتلاء" };

  private IsWidget genLabel() {
    // We test also RTL names
    return new InitialLabel(NAMES[RandomHelper.getInt(0, NAMES.length - 1)],
        Direction.values()[RandomHelper.getInt(0, 2)]);
  }

  @Override
  public void onModuleLoad() {
    final InitialsCss css = InitialsResources.INS.css();
    css.ensureInjected();

    final int sizeFull = 30 * RandomHelper.getInt(1, 3);
    final int padding = 1 * RandomHelper.getInt(1, 2);

    final String url1 = "http://dummyimage.com/" + sizeFull * RandomHelper.getInt(1, 5);
    // final String url2 = "http://dummyimage.com/" + sizeFull *
    // RandomHelper.getInt(1, 5);
    // final String url3 = "http://dummyimage.com/" + sizeFull *
    // RandomHelper.getInt(1, 5);
    final String url2 = "http://placekitten.com/g/" + sizeFull + "/" + sizeFull;
    final String url3 = "http://placekitten.com/g/" + sizeFull + "/" + sizeFull;

    final Builder builder = new AvatarComposite.Builder(sizeFull, padding);

    RootPanel.get().add(builder.build(genLabel()));
    RootPanel.get().add(builder.build(genLabel(), new Image(url2)));
    RootPanel.get().add(builder.build(genLabel(), genLabel(), genLabel()));
    RootPanel.get().add(builder.build(genLabel(), genLabel(), genLabel(), new Image(url3)));
    RootPanel.get().add(builder.build(new Image(url1)));
  }
}
