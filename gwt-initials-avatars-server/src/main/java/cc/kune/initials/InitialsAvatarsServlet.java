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

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitialsAvatarsServlet extends HttpServlet {

  private static final int MAX_IMG_SIZE = 1000;

  // http://txt2re.com/index-java.php3?s=111x111/aba_12ca&5&-19&6&-28&2
  private static final Pattern PARAMS = Pattern.compile("(\\d+)" + "(x)" + "(\\d+)" + "(\\/)"
      + "([\\w@\\.\\-]+)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.UNICODE_CHARACTER_CLASS);

  private static final long serialVersionUID = 3757314092763168153L;

  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse resp)
      throws ServletException, IOException {

    final String path = request.getPathInfo().substring(1);

    final Matcher m = PARAMS.matcher(path);
    if (m.find()) {
      final int width = Math.min(Integer.parseInt(m.group(1)), MAX_IMG_SIZE);
      final int height = Math.min(Integer.parseInt(m.group(3)), MAX_IMG_SIZE);
      final String name = m.group(5);
      InitialsAvatarsServerUtils.doInitialsResponse(resp, width, height, name);
    } else {
      // Wrong params
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

}
