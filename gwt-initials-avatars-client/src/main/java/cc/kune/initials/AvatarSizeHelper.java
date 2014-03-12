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
 * The Class AvatarSizeHelper.
 * 
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class AvatarSizeHelper {

  /**
   * Gets the final size of an avatar depending on the size of the padding (if
   * is odd, etc).
   * 
   * If the original size is, for instance, 50px and the padding is 1px,
   * composite avatars will have a final size of 51px
   * 
   * If the original size is 51px, the final size will we also 51px;
   * 
   * @param avatarSize
   *          the avatar size
   * @param padding
   *          the padding
   * @return the full size
   */
  public static int getFinalSize(final int avatarSize, final int padding) {
    return getHalfSize(avatarSize, padding) * 2 + padding;
  }

  /**
   * Gets the half size.
   * 
   * @param originalSize
   *          the avatar size
   * @param padding
   *          the padding
   * @return the half size
   */
  public static int getHalfSize(final int originalSize, final int padding) {
    final int half = originalSize / 2 - padding / 2;
    return half;
  }
}
