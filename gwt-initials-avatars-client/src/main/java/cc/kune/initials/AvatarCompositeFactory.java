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

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class AvatarCompositeFactory {

  public static AvatarComposite.Builder AV30;
  public static AvatarComposite.Builder AV33;
  public static AvatarComposite.Builder AV40;
  private static ColorProvider colorProvider = new ColorProvider() {
    @Override
    public String getColor(final String key) {
      return colorsCache.getUnchecked(key);
    }
  };

  private static LoadingCache<String, String> colorsCache = CacheBuilder.newBuilder().maximumSize(500).expireAfterAccess(
      InitialsConstants.CACHE_EXP_IN_SECS, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
    @Override
    public String load(final String name) {
      return ColorHelper.getRandomClearColor(name);
    }
  });

  public static AvatarComposite.Builder get30() {
    if (AV30 == null) {
      AV30 = new AvatarComposite.Builder(30, 1);
    }
    return AV30;
  }

  public static AvatarComposite.Builder get33() {
    if (AV33 == null) {
      AV33 = new AvatarComposite.Builder(30, 1);
    }
    return AV33;
  }

  public static AvatarComposite.Builder get40() {
    if (AV40 == null) {
      AV40 = new AvatarComposite.Builder(40, 1);
    }
    return AV40;
  }

  public static cc.kune.initials.ColorProvider getColorProvider() {
    return colorProvider;
  }

  public AvatarCompositeFactory() {

  }

}
