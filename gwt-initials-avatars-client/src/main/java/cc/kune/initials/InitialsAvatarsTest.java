package cc.kune.initials;

import cc.kune.initials.AvatarComposite.Builder;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class InitialsAvatarsTest implements EntryPoint {

  String[] NAMES = new String[] { "Simone", "Luther", "Bertrand", "Ada", "Martin", "吗 台湾", "واعتلاء" };

  private void gen(final String string, final String string2, final String string3, final String string4) {
    RootPanel.get().add(
        AvatarCompositeFactory.get40().build(genLabel(string), genLabel(string2), genLabel(string3),
            genLabel(string4)));
  }

  private IsWidget genLabel(final int i) {
    // We test also RTL names
    return new InitialLabel(NAMES[i] + "@example.com", Direction.values()[RandomHelper.getInt(0, 2)]);
  }

  private IsWidget genLabel(final String i) {
    final InitialLabel l = new InitialLabel(i + "@example.com");
    l.getElement().getStyle().setFloat(Float.LEFT);
    return l;
  }

  @Override
  public void onModuleLoad() {
    InitialsResources.INS.css().ensureInjected();

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

    RootPanel.get().add(builder.build(new InitialLabel("luther")));
    RootPanel.get().add(builder.build(new InitialLabel("blisset")));
    RootPanel.get().add(builder.build(new InitialLabel("blisset")));
    RootPanel.get().add(builder.build(genLabel(5), new Image(url2)));
    RootPanel.get().add(builder.build(genLabel(4), genLabel(3), genLabel(2)));
    RootPanel.get().add(builder.build(genLabel(1), genLabel(2), genLabel(4), new Image(url3)));
    RootPanel.get().add(builder.build(new Image(url1)));
    gen("a", "b", "c", "d");
    gen("d", "l", "s", "1");
    gen("e", "m", "t", "2");
    gen("f", "n", "u", "3");
    gen("g", "ñ", "v", "4");
    gen("h", "o", "w", "5");
    gen("i", "p", "x", "6");
    gen("j", "q", "y", "7");
    gen("k", "r", "z", "8");
  }
}
