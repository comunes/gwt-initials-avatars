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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ColorHelperTest {

  private static final String TEST_STRING = "test";
  private static final String TEST2_STRING = "abcd";
  private static final String TEST3_STRING = "hi";
  private String another;
  private String anotherColor;
  private String oneColor;

  @Before
  public void before() {
    oneColor = ColorHelper.getRandomClearColor(TEST_STRING);
    anotherColor = ColorHelper.getRandomClearColor(TEST2_STRING);
    another = ColorHelper.getRandomClearColor(TEST3_STRING);
  }

  @Test
  public void shouldGenerateRandomColors() {
    assertFalse(oneColor.equals(anotherColor));
    assertFalse(oneColor.equals(another));
  }

  @Test
  public void shouldHaveAColorLenght() {
    assertEquals(7, oneColor.length());
    assertEquals(7, anotherColor.length());
  }

  @Test
  public void shouldHaveAColorPrefix() {
    assertTrue(oneColor.startsWith("#"));
    assertTrue(anotherColor.startsWith("#"));
  }
}
