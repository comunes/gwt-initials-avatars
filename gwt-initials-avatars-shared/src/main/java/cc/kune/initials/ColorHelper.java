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

/**
 * The Class InitialsColorHelper.
 * 
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class ColorHelper {

  /** The MAX color constant. */
  private static final int MAX = 200;

  /** The MIN color constant. */
  private static final int MIN = 60;

  /**
   * Gets a random clear color suitable for use in placeholder avatars
   * 
   * Inspired in <a href=
   * "https://github.com/lmoffereins/initials-default-avatar/blob/master/initials-default-avatar.php"
   * >this</a>.
   * 
   * @return the random
   */
  public static String getRandomClearColor() {
    // This should return a random but clear color for an initial avatar
    final int red = getRandomInt();
    final int blue = getRandomInt();
    final int green = getRandomInt();
    return rgbToHex(red, blue, green);
  }

  public static int getRandomInt() {
    return RandomHelper.getInt(MIN, MAX);
  }

  /**
   * RGB to hex based in <a
   * href="http://stackoverflow.com/questions/15403471/use-color-class-in-gwt"
   * >this</a>
   * 
   * @param r
   *          the red
   * @param g
   *          the green
   * @param b
   *          the blue
   * @return the color string
   */
  public static String rgbToHex(final int r, final int g, final int b) {
    final StringBuilder sb = new StringBuilder();
    sb.append('#').append(Integer.toHexString(r)).append(Integer.toHexString(g)).append(
        Integer.toHexString(b));
    return sb.toString();
  }

  /**
   * Instantiates a new color helper.
   */
  public ColorHelper() {
  }
}
