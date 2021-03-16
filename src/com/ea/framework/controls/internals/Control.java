package com.ea.framework.controls.internals;

import com.ea.framework.controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

/**
 * Created by Karthik-pc on 12/10/2016.
 */

@ImplementedBy(ControlBase.class)
public interface Control extends WebElement, WrapsElement, Locatable {
}
