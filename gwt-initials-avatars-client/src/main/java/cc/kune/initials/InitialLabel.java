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

import cc.kune.initials.InitialsResources.InitialsCss;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;

public class InitialLabel extends Label {

  public InitialLabel(final String text) {
    this(text, Direction.DEFAULT);
  }

  public InitialLabel(final String name, final Direction direction) {
    super();
    final InitialsCss css = InitialsResources.INS.css();
    addStyleName(css.def());
    final int len = name.length();
    setText(name.substring(getTextDirection().equals(Direction.RTL) ? len - 1 : 0, 1));
  }

  public void setStyle(final int height, final int fontSize) {
    final Style style = getElement().getStyle();
    style.setBackgroundColor(ColorHelper.getRandomClearColor());
    style.setLineHeight(height, Unit.PX);
    style.setFontSize(fontSize, Unit.PX);
  }

}
