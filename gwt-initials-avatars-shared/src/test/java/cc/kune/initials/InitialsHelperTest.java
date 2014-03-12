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

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InitialsHelperTest {

  @Before
  public void before() {
  }

  private List<String> list(final String... initials) {
    return new ArrayList<String>(Arrays.asList(initials));
  }

  @Test
  public void shouldFontSizes() {
    assertEquals(80f, 100 * InitialsConstants.BIG_FONT_FACTOR, 0);
  }

  @Test
  public void shouldReturnLessThanFourInOrder() {
    // @SuppressWarnings();
    assertEquals(list("abc", "def"), InitialsHelper.getFour(list("abc", "def")));
    assertEquals(list("abc"), InitialsHelper.getFour(list("abc")));
    assertEquals(list("abc", "def", "ghi"), InitialsHelper.getFour(list("abc", "def", "ghi")));
    assertEquals(list("abc", "def", "ghi", "jkl"),
        InitialsHelper.getFour(list("abc", "def", "ghi", "jkl")));
  }

  @Test
  public void shouldReturnMoreThanFourRandomly() {
    assertEquals(4, InitialsHelper.getFour(list("abc", "def", "ghi", "jkl", "mnñ")).size());
    assertEquals("abc", InitialsHelper.getFour(list("abc", "def", "ghi", "jkl", "mnñ")).get(0));
  }

}
