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

import java.util.Collections;
import java.util.List;

/**
 * The Class InitialsHelper.
 * 
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class InitialsHelper {
  /**
   * Gets a random int starting from one.
   * 
   * @param len
   *          the len
   * @return the a random
   */
  private static int getARandom(final int len) {
    // We start in 1 because names[0] is already choosed
    return RandomHelper.getInt(1, len - 1);
  }

  /**
   * Gets the four elements, and gets randomly three maintaining the first.
   * 
   * @param names
   *          the names
   * @return the four and swap
   */
  public static List<?> getFour(final List<?> names) {
    return names.subList(0, getMaxSize(names));
  }

  /**
   * Gets the four elements, and gets randomly three maintaining the first.
   * 
   * @param names
   *          the names
   * @return the four and swap
   */
  public static List<?> getFourAndSwap(final List<?> names) {
    return swap(names).subList(0, getMaxSize(names));
  }

  public static int getMaxSize(final List<?> list) {
    return list.size() > 4 ? 4 : list.size();
  }

  /**
   * Swap the last three elements of a list.
   * 
   * @param list
   *          the list
   * @return the list
   */
  private static List<?> swap(final List<?> list) {
    // We maintain the first in the first position
    for (int index = 1; index < list.size(); index++) {
      Collections.swap(list, index, getARandom(list.size()));
    }
    return list;
  }

}
