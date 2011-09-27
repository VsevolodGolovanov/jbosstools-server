/******************************************************************************* 
 * Copyright (c) 2007 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/
package org.jboss.ide.eclipse.as.openshift.test.internal.core.utils;

import org.jboss.ide.eclipse.as.openshift.core.Cartridge;
import org.jboss.ide.eclipse.as.openshift.core.ICartridge;
import org.jboss.ide.eclipse.as.openshift.core.OpenshiftException;
import org.jboss.ide.eclipse.as.openshift.core.internal.Application;
import org.jboss.ide.eclipse.as.openshift.core.internal.IOpenshiftService;
import org.jboss.ide.eclipse.as.openshift.core.internal.InternalUser;

/**
 * @author André Dietisheim
 */
public class ApplicationUtils {

	public static String createRandomApplicationName() {
		return String.valueOf(System.currentTimeMillis());
	}

	public static Application createApplication(InternalUser internalUser, IOpenshiftService service) throws OpenshiftException {
		return service.createApplication(createRandomApplicationName(), Cartridge.JBOSSAS_7, internalUser);
	}
	
	public static void silentlyDestroyAS7Application(String name, InternalUser internalUser, IOpenshiftService service) {
		try {
			service.destroyApplication(name, ICartridge.JBOSSAS_7, internalUser);
		} catch (OpenshiftException e) {
			e.printStackTrace();
		}
	}
}