package org.jenkinsci.plugins.dailyquote;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.Util;
import hudson.model.PageDecorator;

@Extension
public class DailyQuotePageDecorator extends PageDecorator {

    private boolean enabled;

    @DataBoundConstructor
    public DailyQuotePageDecorator (boolean enabled) {
        this();
        this.enabled = enabled;
    }
    
    public DailyQuotePageDecorator() {
        super(DailyQuotePageDecorator.class);
        load();
    }

    @Override
    public String getDisplayName() {
        return "Daily Quote";
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        req.bindJSON(this, json);
        save();
        return true;
    }

    public boolean getEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(boolean enabled ) {
      this.enabled = enabled ;
    }
}
