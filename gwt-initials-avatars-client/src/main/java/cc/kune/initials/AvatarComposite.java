/*
 *
 * Copyright (C) 2007-2013 Licensed to the Comunes Association (CA) under
 * one or more contributor license agreements (see COPYRIGHT for details).
 * The CA licenses this file to you under the GNU Affero General Public
 * License version 3, (the "License"); you may not use this file except in
 * compliance with the License. This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package cc.kune.initials;

import static com.google.gwt.dom.client.Style.Unit.PX;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;

public class AvatarComposite extends Composite {

  public static class Builder {
    private final int[][][] avatarSizes;
    private final int[][] fontSizes;
    private final int fullSize;

    public Builder(final int originalSize, final int padding) {
      final int halfSize = AvatarSizeHelper.getHalfSize(originalSize, padding);
      fullSize = AvatarSizeHelper.getFinalSize(originalSize, padding);
      // @formatter:off
      avatarSizes = new int [][][] {
          // one widget
          {{ 0, fullSize, 0, fullSize}},
          // two widgets
          {{ 0, fullSize, 0, halfSize},
           { 0, fullSize, halfSize + padding, halfSize} },
          // three widgets
          {{ 0, fullSize, 0, halfSize},
           { 0, halfSize, halfSize + padding, halfSize},
           { padding + halfSize, halfSize, halfSize + padding, halfSize} },
          // four widgets
          {{ 0, halfSize, 0, halfSize},
           { halfSize + padding, halfSize, 0, halfSize},
           { 0, halfSize, halfSize + padding, halfSize},
           { halfSize + padding, halfSize, halfSize + padding, halfSize} }};
      final int bigFontSize = (int) (fullSize * InitialsConstants.BIG_FONT_FACTOR);
      final int mediumFontSize = (int) (halfSize * InitialsConstants.MEDIUM_FONT_FACTOR);
      final int smallFontSize =  (int) (halfSize * InitialsConstants.SMALL_FONT_FACTOR);
      fontSizes = new int[][] {
          {bigFontSize},
          {mediumFontSize, mediumFontSize},
          {mediumFontSize, smallFontSize, smallFontSize},
          {smallFontSize, smallFontSize, smallFontSize, smallFontSize}};
      // @formatter:on
    }

    public AvatarComposite build(final IsWidget... widgets) {
      return build(new LinkedList<IsWidget>(Arrays.asList(widgets)));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public AvatarComposite build(final LinkedList<IsWidget> widgets) {
      final List list = InitialsAvatarListHelper.getFour(widgets);
      return new AvatarComposite(this, avatarSizes[list.size() - 1], fontSizes[list.size() - 1], list);
    }

    public int getSize() {
      return fullSize;
    }
  }

  public AvatarComposite(final Builder builder, final int[][] sizes, final int[] fontSizes,
      final List<IsWidget> widgets) {
    final LayoutPanel panel = new LayoutPanel();
    final int fullSize = builder.getSize();
    panel.setSize(fullSize + "px", fullSize + "px");
    for (int i = 0; i < widgets.size(); i++) {
      final int top = sizes[i][0];
      final int height = sizes[i][1];
      final int left = sizes[i][2];
      final int width = sizes[i][3];
      final int finalWidth = width - left;
      final int finalHeight = height - top;
      final IsWidget widget = widgets.get(i);
      IsWidget wrap = widget;
      if (widget instanceof InitialLabel) {
        ((InitialLabel) widget).setStyle(height, fontSizes[i]);
      } else if (widget instanceof Image) {
        // If is an image, we crop/resize in the center of the image
        wrap = ImagesHelper.cropResize((Image) widget, fullSize, finalWidth, finalHeight);
      }
      panel.add(wrap);
      panel.setWidgetTopHeight(wrap, top, PX, height, PX);
      panel.setWidgetLeftWidth(wrap, left, PX, width, PX);
    }
    initWidget(panel);
  }
}
